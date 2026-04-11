package com.banana.blog.domain.dtos;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // we can use @Data because we dont interact with the database and not an entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private UUID id;
    private String name;
    private Long postCount; // we can use this to show how many posts are in this category
}
