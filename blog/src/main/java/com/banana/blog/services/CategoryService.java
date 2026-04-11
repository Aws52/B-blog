package com.banana.blog.services;

import java.util.List;

import com.banana.blog.domain.entities.Category;

public interface CategoryService {
    List<Category> listCategories();
}
