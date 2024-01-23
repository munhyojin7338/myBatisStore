package com.example.mybatisStore.order.cart.controller;

import com.example.mybatisStore.order.cart.entity.Cart;
import com.example.mybatisStore.order.cart.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @PostMapping("/addCart")
    public ResponseEntity<?> addCart(@RequestBody Cart cart) {
        cartService.addToCart(cart);
        return ResponseEntity.ok().build();
    }
}
