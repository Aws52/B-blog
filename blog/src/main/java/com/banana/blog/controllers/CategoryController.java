package com.banana.blog.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banana.blog.domain.dtos.CategoryDto;
import com.banana.blog.domain.dtos.CreateCategoryRequest;
import com.banana.blog.domain.entities.Category;
import com.banana.blog.mappers.CategoryMapper;
import com.banana.blog.services.CategoryService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(path = "api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> listCategories(){
        List<CategoryDto> categories = categoryService.listCategories()
        .stream().map(categoryMapper::toDto)
        .toList();

        return ResponseEntity.ok(categories);
    }

    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(
        @Valid @RequestBody CreateCategoryRequest createCategoryRequest){

        Category categoryToCreate = categoryMapper.toEntity(createCategoryRequest);
        Category savedCategory = categoryService.createCategory(categoryToCreate);

        return new ResponseEntity<>(
            categoryMapper.toDto(savedCategory), 
            HttpStatus.CREATED
        );
    }
}
