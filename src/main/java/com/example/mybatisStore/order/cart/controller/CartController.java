package com.example.mybatisStore.order.cart.controller;

import com.example.mybatisStore.order.cart.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;
}
