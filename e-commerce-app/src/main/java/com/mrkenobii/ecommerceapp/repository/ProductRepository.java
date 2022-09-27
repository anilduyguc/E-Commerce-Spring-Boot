package com.mrkenobii.ecommerceapp.repository;

import com.mrkenobii.ecommerceapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
