package com.jeyhung.graphql.service;

import com.jeyhung.graphql.dto.response.AuthorDto;

import java.util.List;
import java.util.UUID;

public interface AuthorService {
    List<AuthorDto> getAuthors(int page, int size);
    boolean checkExistsById(UUID id);
}
