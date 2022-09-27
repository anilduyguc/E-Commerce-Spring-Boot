package com.mrkenobii.ecommerceapp.service;

import com.mrkenobii.ecommerceapp.dto.cart.CartDto;
import com.mrkenobii.ecommerceapp.dto.cart.CartItemDto;
import com.mrkenobii.ecommerceapp.dto.cart.CartResponseDto;
import com.mrkenobii.ecommerceapp.exception.CustomException;
import com.mrkenobii.ecommerceapp.exception.ProductNotExistException;
import com.mrkenobii.ecommerceapp.model.Cart;
import com.mrkenobii.ecommerceapp.model.Product;
import com.mrkenobii.ecommerceapp.model.User;
import com.mrkenobii.ecommerceapp.repository.CartRepository;
import com.mrkenobii.ecommerceapp.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    private final AuthenticationService authenticationService;
    private final ProductRepository productRepository;
    public Cart addToCart(@NotNull CartDto cartDto, String token) {
        authenticationService.authenticate(token);
        User user = authenticationService.getUser(token);
        Product product = productRepository.findById(cartDto.getProductId())
                .orElseThrow(()->new ProductNotExistException("Product is not valid " + cartDto.getProductId()));
        Cart cart = new Cart();
        cart.setProduct(product);
        cart.setUser(user);
        cart.setQuantity(cartDto.getQuantity());
        cart.setCreatedDate(new Date());
        return cartRepository.save(cart);
    }

    public CartResponseDto getAllItemsFromCart(String token) {
        authenticationService.authenticate(token);
        User user = authenticationService.getUser(token);
        return this.listCartItems(user);
    }

    private CartResponseDto listCartItems(User user) {
        final List<Cart> cartList = cartRepository.findAllByUserOrderByCreatedDateDesc(user);
        List<CartItemDto> cartItems = new ArrayList<>();
        Double totalCost =0D;
        for(Cart cart: cartList){
            CartItemDto cartItemDto = new CartItemDto();
            cartItemDto.setProduct(cart.getProduct());
            cartItemDto.setQuantity(cart.getQuantity());
            cartItemDto.setId(cart.getId());
            totalCost+=cartItemDto.getQuantity() * cart.getProduct().getPrice();

            cartItems.add(cartItemDto);
        }
        CartResponseDto cartResponseDto = new CartResponseDto();
        cartResponseDto.setTotalCost(totalCost);
        cartResponseDto.setCartItems(cartItems);
        return cartResponseDto;
    }

    public Cart deleteCartItem(String cartItemId, String token) {
        authenticationService.authenticate(token);
        User user = authenticationService.getUser(token);
        Cart cart = cartRepository.findById(Integer.parseInt(cartItemId))
                .orElseThrow(() -> new CustomException("Cart item with id: " + cartItemId + " is not valid"));
        if(cart.getUser() != user)
            throw new CustomException("Cart item with id: "+ cartItemId + "does not belong to user");
        cartRepository.delete(cart);
        return cart;
    }
}
