package com.mrkenobii.ecommerceapp.controller;

import com.mrkenobii.ecommerceapp.model.Product;
import com.mrkenobii.ecommerceapp.model.User;
import com.mrkenobii.ecommerceapp.model.WishList;
import com.mrkenobii.ecommerceapp.service.AuthenticationService;
import com.mrkenobii.ecommerceapp.service.WishListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/wish-list")
@RequiredArgsConstructor
public class WishListController {
    private final WishListService wishListService;
    private final AuthenticationService authenticationService;

    @PostMapping("/add")
    public ResponseEntity<WishList> addToWishList(@RequestBody Product product, @RequestParam("token") String token){
        authenticationService.authenticate(token);
        User user = authenticationService.getUser(token);
        WishList wishList = new WishList(user, product);
        return new ResponseEntity<>(wishListService.createWishList(wishList), HttpStatus.CREATED);

    }
}
