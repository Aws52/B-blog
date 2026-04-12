package com.banana.blog.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.banana.blog.domain.entities.Category;
import com.banana.blog.repositories.CategoryRepository;
import com.banana.blog.services.CategoryService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> listCategories() {
        return categoryRepository.findAllWithPostCount();
    }

    @Override
    @Transactional //annotation to make sure that group of operations are executed in a single transaction,
    //  if any operation fails, the entire transaction will be rolled back to maintain data integrity
    public Category createCategory(Category category) {
        if (categoryRepository.existsByNameIgnoreCase(category.getName())) {
            throw new IllegalArgumentException("Category already exists with name: " + category.getName());
        }
        return categoryRepository.save(category);
    }
}