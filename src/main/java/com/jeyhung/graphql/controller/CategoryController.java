package com.jeyhung.graphql.controller;

import com.jeyhung.graphql.dto.response.CategoryDto;
import com.jeyhung.graphql.service.CategoryService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @QueryMapping
    public List<CategoryDto> getCategories(@Argument int page, @Argument int size) {
        return categoryService.getCategories(page, size);
    }
}
