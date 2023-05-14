package com.jeyhung.graphql.service;

import com.jeyhung.graphql.dto.response.CategoryDto;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    List<CategoryDto> getCategories(int page, int size);
    boolean checkExistsById(UUID id);
}
