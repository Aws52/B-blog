package com.banana.blog.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.banana.blog.domain.entities.Category;
import com.banana.blog.repositories.CategoryRepository;
import com.banana.blog.services.CategoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> listCategories() {
        return categoryRepository.findAllWithPostCount();
    }

}
