package com.mrkenobii.ecommerceapp.repository;

import com.mrkenobii.ecommerceapp.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
