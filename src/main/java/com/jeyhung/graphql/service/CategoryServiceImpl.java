package com.jeyhung.graphql.service;

import com.jeyhung.graphql.dto.response.CategoryDto;
import com.jeyhung.graphql.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CategoryDto> getCategories(int page, int size) {
        return categoryRepository.findAll(PageRequest.of(page, size))
                .getContent()
                .stream()
                .map(e -> modelMapper.map(e, CategoryDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public boolean checkExistsById(UUID id) {
        return categoryRepository.existsById(id);
    }
}
