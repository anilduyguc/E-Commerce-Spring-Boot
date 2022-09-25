package com.mrkenobii.ecommerceapp.repository;

import com.mrkenobii.ecommerceapp.model.WishList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishListRepository extends JpaRepository<WishList, Integer> {
}
