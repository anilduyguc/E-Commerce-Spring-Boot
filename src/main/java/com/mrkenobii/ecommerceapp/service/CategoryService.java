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
}
