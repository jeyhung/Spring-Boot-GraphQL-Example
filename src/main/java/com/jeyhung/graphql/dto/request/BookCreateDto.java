package com.jeyhung.graphql.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookCreateDto {
    private String isbn;
    private String title;
    private String publisher;
    private LocalDate publishedAt;
    private Double price;
    private UUID categoryId;
    private List<UUID> authorIds;
}
