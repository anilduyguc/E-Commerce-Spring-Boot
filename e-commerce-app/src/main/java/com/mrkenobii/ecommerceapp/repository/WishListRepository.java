package com.mrkenobii.ecommerceapp.repository;

import com.mrkenobii.ecommerceapp.model.User;
import com.mrkenobii.ecommerceapp.model.WishList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WishListRepository extends JpaRepository<WishList, Integer> {
    List<WishList> findAllByUserOrderByCreatedDateDesc(User user);
}
