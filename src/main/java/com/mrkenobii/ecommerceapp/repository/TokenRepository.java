package com.mrkenobii.ecommerceapp.repository;

import com.mrkenobii.ecommerceapp.model.AuthenticationToken;
import com.mrkenobii.ecommerceapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<AuthenticationToken, Integer> {
    AuthenticationToken findByUser(User user);
    AuthenticationToken findByToken(String token);
}
