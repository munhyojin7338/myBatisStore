package com.example.mybatisStore.order.cart.repository;

import com.example.mybatisStore.order.cart.entity.Cart;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;

@Mapper
public interface CartMapper {

    // 장바구니에 물건을 추가 하는 로직
    @Insert("INSERT INTO carts (id, product_id, count, prices) VALUES (#{id}, #{productId}, #{count}, #{prices})")
    void addCart(Cart cart);

    // 상품 가격을 가져오는 메서드
    String getProductPrice(Long productId);
}
