package com.mrkenobii.ecommerceapp.service;

import com.mrkenobii.ecommerceapp.model.Category;
import com.mrkenobii.ecommerceapp.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Category createCategory(Category category){
        return categoryRepository.save(category);
    }

    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    public Category updateCategory(Category category, String categoryId) {
        Category category1 = categoryRepository.findById(Integer.parseInt(categoryId))
                .orElseThrow(() -> new RuntimeException("Category does not exist with id: " + categoryId));
        category1.setCategoryName(category.getCategoryName());
        category1.setDescription(category.getDescription());
        category1.setImageUrl(category.getImageUrl());
        return categoryRepository.save(category1);
    }
}
