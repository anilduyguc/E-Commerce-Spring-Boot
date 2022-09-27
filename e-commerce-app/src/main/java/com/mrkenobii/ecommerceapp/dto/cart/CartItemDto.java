package com.mrkenobii.ecommerceapp.dto.cart;

import com.mrkenobii.ecommerceapp.model.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CartItemDto {
    private Integer id;
    private Integer quantity;
    private Product product;
}
