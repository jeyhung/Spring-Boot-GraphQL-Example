package com.jeyhung.graphql.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "books")
public class Book {
    @Id
    private UUID id;
    @Indexed(unique = true)
    private String isbn;
    private String title;
    private String publisher;
    private LocalDate publishedAt;
    private Double price;
    private Category category;
    @DBRef
    private List<Author> authors;
    private LocalDateTime createdAt;
}
