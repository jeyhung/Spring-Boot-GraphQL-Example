package com.jeyhung.graphql.controller;

import com.jeyhung.graphql.dto.response.AuthorDto;
import com.jeyhung.graphql.service.AuthorService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @QueryMapping
    public List<AuthorDto> getAuthors(@Argument int page, @Argument int size) {
        return authorService.getAuthors(page, size);
    }
}
