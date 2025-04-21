package com.example.duancanhan.service;

import com.example.duancanhan.model.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<Category> getAllCategories();
    Optional<Category> findById(Long id);
    void saveCategory(Category category);
    void updateCategory(Long id, Category category);
    void deleteCategory(Long id);
}
