package com.jeyhung.graphql.service;

import com.jeyhung.graphql.dto.request.BookCreateDto;
import com.jeyhung.graphql.dto.request.BookUpdateDto;
import com.jeyhung.graphql.dto.response.BookDto;
import com.jeyhung.graphql.entity.Book;
import com.jeyhung.graphql.exception.DataDuplicatedException;
import com.jeyhung.graphql.exception.DataNotFoundException;
import com.jeyhung.graphql.exception.WrongParamsException;
import com.jeyhung.graphql.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
public class BookServiceImpl implements BookService {
    private final AuthorService authorService;
    private final CategoryService categoryService;
    private final BookRepository bookRepository;
    private final ModelMapper mapper;

    public BookServiceImpl(AuthorService authorService,
                           CategoryService categoryService,
                           BookRepository bookRepository,
                           ModelMapper mapper) {
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.bookRepository = bookRepository;
        this.mapper = mapper;
    }

    @Override
    public List<BookDto> getBooks(int page, int size) {
        return bookRepository.findAll(PageRequest.of(page, size))
                .getContent()
                .stream()
                .map(e -> mapper.map(e, BookDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public BookDto getBookById(UUID id) {
        Book book = findBookById(id);
        return mapper.map(book, BookDto.class);
    }

    @Override
    public UUID createBook(BookCreateDto bookCreateDto) {
        checkBookIsbnExists(Optional.empty(), bookCreateDto.getIsbn());
        checkCategoryExists(bookCreateDto.getCategoryId());
        checkAuthorsExist(bookCreateDto.getAuthorIds());

        Book book = mapper.map(bookCreateDto, Book.class);
        book.setId(UUID.randomUUID());
        book.setCreatedAt(LocalDateTime.now());
        bookRepository.save(book);
        return book.getId();
    }

    @Override
    public void updateBook(BookUpdateDto bookUpdateDto) {
        checkBookIsbnExists(Optional.of(bookUpdateDto.getId()), bookUpdateDto.getIsbn());
        checkCategoryExists(bookUpdateDto.getCategoryId());
        checkAuthorsExist(bookUpdateDto.getAuthorIds());

        Book book = findBookById(bookUpdateDto.getId());
        mapper.map(bookUpdateDto, book);
        bookRepository.save(book);
    }

    private Book findBookById(UUID id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(String.format("Book with Id %s not found!", id)));

    }

    private void checkBookIsbnExists(Optional<UUID> optionalId, String isbn) {
        boolean bookExists;

        if (optionalId.isPresent()) {
            bookExists = bookRepository.existsByIdNotAndIsbn(optionalId.get(), isbn);
        } else {
            bookExists = bookRepository.existsByIsbn(isbn);
        }

        if (bookExists) {
            DataDuplicatedException.handle(String.format("Book with ISBN %s already existed!", isbn));
        }
    }

    private void checkCategoryExists(UUID categoryId) {
        boolean categoryExists = categoryService.checkExistsById(categoryId);
        if (!categoryExists) {
            DataNotFoundException.handle(String.format("Category with Id %s not found!", categoryId));
        }
    }

    private void checkAuthorsExist(List<UUID> authorIds) {
        if (authorIds != null && authorIds.size() > 0) {
            authorIds.forEach(authorId -> {
                boolean authorExists = authorService.checkExistsById(authorId);
                if (!authorExists) {
                    DataNotFoundException.handle(String.format("Author with Id %s not found!", authorId));
                }
            });
        } else {
            WrongParamsException.handle("Authors field is required!");
        }
    }
}