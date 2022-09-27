package com.mrkenobii.ecommerceapp.dto.checkout;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CheckoutItemDto {
    private String productName;
    private Integer quantity;
    private Double price;
    private Long productId;
    private Integer userId;
}
