package com.jeyhung.graphql.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDto {
    private UUID id;
    private String firstName;
    private String lastName;
    private LocalDateTime createdAt;
}
