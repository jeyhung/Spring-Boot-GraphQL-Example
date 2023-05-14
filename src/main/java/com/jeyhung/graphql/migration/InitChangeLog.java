package com.jeyhung.graphql.migration;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.jeyhung.graphql.entity.Author;
import com.jeyhung.graphql.entity.Category;
import com.jeyhung.graphql.repository.AuthorRepository;
import com.jeyhung.graphql.repository.CategoryRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ChangeLog
public class InitChangeLog {
    @ChangeSet(order = "001", id = "init_authors", author = "jeyhung")
    public void initAuthors(AuthorRepository authorRepository) {
        List<Author> authors = new ArrayList<>();

        authors.add(Author.builder()
                .id(UUID.randomUUID())
                .firstName("Agatha")
                .lastName("Christie")
                .createdAt(LocalDateTime.now())
                .build());

        authors.add(Author.builder()
                .id(UUID.randomUUID())
                .firstName("Stephen")
                .lastName("King")
                .createdAt(LocalDateTime.now())
                .build());

        authors.add(Author.builder()
                .id(UUID.randomUUID())
                .firstName("John")
                .lastName("Grisham")
                .createdAt(LocalDateTime.now())
                .build());

        authorRepository.insert(authors);
    }

    @ChangeSet(order = "002", id = "init_categories", author = "jeyhung")
    public void initCategories(CategoryRepository categoryRepository) {
        List<Category> categories = new ArrayList<>();

        categories.add(Category.builder()
                .id(UUID.randomUUID())
                .name("Classics")
                .createdAt(LocalDateTime.now())
                .build());

        categories.add(Category.builder()
                .id(UUID.randomUUID())
                .name("Romance")
                .createdAt(LocalDateTime.now())
                .build());

        categories.add(Category.builder()
                .id(UUID.randomUUID())
                .name("Novel")
                .createdAt(LocalDateTime.now())
                .build());

        categories.add(Category.builder()
                .id(UUID.randomUUID())
                .name("Novel")
                .createdAt(LocalDateTime.now())
                .build());

        categoryRepository.insert(categories);
    }
}