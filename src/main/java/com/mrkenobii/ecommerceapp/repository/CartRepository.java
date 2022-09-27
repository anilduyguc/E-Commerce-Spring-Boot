package com.mrkenobii.ecommerceapp.repository;

import com.mrkenobii.ecommerceapp.model.Cart;
import com.mrkenobii.ecommerceapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Integer> {
    List<Cart> findAllByUserOrderByCreatedDateDesc(User user);
}
