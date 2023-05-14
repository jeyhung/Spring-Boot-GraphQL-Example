package com.jeyhung.graphql.service;

import com.jeyhung.graphql.dto.request.BookCreateDto;
import com.jeyhung.graphql.dto.request.BookUpdateDto;
import com.jeyhung.graphql.dto.response.BookDto;

import java.util.List;
import java.util.UUID;

public interface BookService {
    List<BookDto> getBooks(int page, int size);
    BookDto getBookById(UUID id);
    UUID createBook(BookCreateDto bookCreateDto);
    void updateBook(BookUpdateDto bookUpdateDto);
}
