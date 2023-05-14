package com.jeyhung.graphql.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private UUID id;
    private String isbn;
    private String title;
    private String publisher;
    private LocalDateTime publishedAt;
    private Double price;
    private CategoryDto category;
    private List<AuthorDto> authors;
    private LocalDateTime createdAt;
}
