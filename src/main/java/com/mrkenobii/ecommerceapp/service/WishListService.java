package com.mrkenobii.ecommerceapp.service;

import com.mrkenobii.ecommerceapp.model.WishList;
import com.mrkenobii.ecommerceapp.repository.WishListRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WishListService {
    private final WishListRepository wishListRepository;
    public WishList createWishList(WishList wishList) {
        return wishListRepository.save(wishList);
    }
}
