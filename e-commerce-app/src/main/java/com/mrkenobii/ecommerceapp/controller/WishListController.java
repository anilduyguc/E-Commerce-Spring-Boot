package com.mrkenobii.ecommerceapp.controller;

import com.mrkenobii.ecommerceapp.dto.ProductDto;
import com.mrkenobii.ecommerceapp.model.Product;
import com.mrkenobii.ecommerceapp.model.User;
import com.mrkenobii.ecommerceapp.model.WishList;
import com.mrkenobii.ecommerceapp.service.AuthenticationService;
import com.mrkenobii.ecommerceapp.service.WishListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

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
        WishList wishList = new WishList();
        wishList.setUser(user);
        wishList.setProduct(product);
        wishList.setCreatedDate(new Date());
        System.out.println(wishList);
        return new ResponseEntity<>(wishListService.createWishList(wishList), HttpStatus.CREATED);
    }
    @GetMapping("/{token}")
    public ResponseEntity<List<ProductDto>> getWishList(@PathVariable String token){
        authenticationService.authenticate(token);
        User user = authenticationService.getUser(token);
        return new ResponseEntity<>(wishListService.getWishListForUser(user), HttpStatus.OK);
    }
}
