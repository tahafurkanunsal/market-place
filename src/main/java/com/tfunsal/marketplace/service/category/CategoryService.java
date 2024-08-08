package com.tfunsal.marketplace.service.category;

import com.tfunsal.marketplace.model.Category;

import java.util.List;

public interface CategoryService {

    Category getCategoryById(Long id);

    Category getCategoryByName(String name);

    List<Category> getAllCategories();

    Category addCategory(Category category);

    Category updateCategory(Category category , Long id);

    void deleteCategoryById(Long id);
}
