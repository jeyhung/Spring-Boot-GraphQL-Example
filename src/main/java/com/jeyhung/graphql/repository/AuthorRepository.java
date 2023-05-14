package com.jeyhung.graphql.repository;

import com.jeyhung.graphql.entity.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface AuthorRepository extends MongoRepository<Author, UUID> {
}