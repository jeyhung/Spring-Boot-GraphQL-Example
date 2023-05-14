package com.jeyhung.graphql.controller;

import com.jeyhung.graphql.dto.request.BookCreateDto;
import com.jeyhung.graphql.dto.request.BookUpdateDto;
import com.jeyhung.graphql.dto.response.BookDto;
import com.jeyhung.graphql.service.BookService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Controller
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @QueryMapping
    public List<BookDto> getBooks(@Argument int page, @Argument int size) {
        return bookService.getBooks(page, size);
    }

    @QueryMapping
    public BookDto getBookById(@Argument UUID id) {
        return bookService.getBookById(id);
    }

    @MutationMapping
    public UUID createBook(@Argument(name = "book") BookCreateDto bookCreateDto) {
        return bookService.createBook(bookCreateDto);
    }

    @MutationMapping
    public void updateBook(@Argument(name = "book") BookUpdateDto bookUpdateDto) {
        bookService.updateBook(bookUpdateDto);
    }
}