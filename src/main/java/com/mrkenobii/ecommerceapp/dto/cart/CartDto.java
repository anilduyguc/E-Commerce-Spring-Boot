package com.mrkenobii.ecommerceapp.dto.cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Data
public class CartDto {
    private Integer id;
    private @NotNull Integer productId;
    private @NotNull Integer quantity;
}
