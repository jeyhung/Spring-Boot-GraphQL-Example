package com.jeyhung.graphql.service;

import com.jeyhung.graphql.dto.response.AuthorDto;
import com.jeyhung.graphql.repository.AuthorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final ModelMapper modelMapper;

    public AuthorServiceImpl(AuthorRepository authorRepository, ModelMapper modelMapper) {
        this.authorRepository = authorRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<AuthorDto> getAuthors(int page, int size) {
        return authorRepository.findAll(PageRequest.of(page, size))
                .getContent()
                .stream()
                .map(e -> modelMapper.map(e, AuthorDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public boolean checkExistsById(UUID id) {
        return authorRepository.existsById(id);
    }
}
