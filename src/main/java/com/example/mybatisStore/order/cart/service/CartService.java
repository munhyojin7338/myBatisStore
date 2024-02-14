package com.example.mybatisStore.order.cart.service;

import com.example.mybatisStore.order.cart.entity.Cart;
import com.example.mybatisStore.order.cart.repository.CartMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartMapper cartMapper;
    /*
        Cart(장바구니)에 Store(상품)를 추가하는 작업
    */
    public void addToCart(Cart cart) {
        // 상품의 가격 정보를 가져와서 Cart 객체에 설정
        String productPrice = getProductPrice(cart.getProductId()); // 상품의 가격을 가져오는 메서드
        cart.setPrices(productPrice);
        cartMapper.addCart(cart);
    }

    public String getProductPrice(Long productId) {
        return cartMapper.getProductPrice(productId);
    }


}
