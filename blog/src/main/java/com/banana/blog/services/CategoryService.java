package com.banana.blog.services;

import java.util.List;
import java.util.UUID;

import com.banana.blog.domain.entities.Category;

public interface CategoryService {
    List<Category> listCategories();
    Category createCategory(Category category);
    void deleteCategory(UUID id);
}
