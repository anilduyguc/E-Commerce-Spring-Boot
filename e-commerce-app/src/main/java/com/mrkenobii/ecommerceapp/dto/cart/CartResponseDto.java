package com.mrkenobii.ecommerceapp.dto.cart;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CartResponseDto {
    private List<CartItemDto> cartItems;
    private Double totalCost;

}
