package com.mrkenobii.ecommerceapp.service;

import com.mrkenobii.ecommerceapp.dto.ProductDto;
import com.mrkenobii.ecommerceapp.model.User;
import com.mrkenobii.ecommerceapp.model.WishList;
import com.mrkenobii.ecommerceapp.repository.WishListRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WishListService {
    private final WishListRepository wishListRepository;
    private final ProductService productService;
    public WishList createWishList(WishList wishList) {
        return wishListRepository.save(wishList);
    }

    public List<ProductDto> getWishListForUser(User user) {
        final List<WishList> wishLists = wishListRepository.findAllByUserOrderByCreatedDateDesc(user);
        List<ProductDto> productDtos = new ArrayList<>();
        for(WishList wishList: wishLists){
            productDtos.add(productService.mapToDto(wishList.getProduct()));
        }
        return productDtos;
    }
}
