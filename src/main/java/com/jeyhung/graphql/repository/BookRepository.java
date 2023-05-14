package com.jeyhung.graphql.repository;

import com.jeyhung.graphql.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface BookRepository extends MongoRepository<Book, UUID> {
    boolean existsByIsbn(String isbn);

    boolean existsByIdNotAndIsbn(UUID id, String isbn);
}