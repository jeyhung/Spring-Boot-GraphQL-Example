package com.jeyhung.graphql.repository;

import com.jeyhung.graphql.entity.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface CategoryRepository extends MongoRepository<Category, UUID> {
}