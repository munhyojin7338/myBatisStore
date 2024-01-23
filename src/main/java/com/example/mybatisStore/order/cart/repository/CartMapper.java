package com.example.mybatisStore.order.cart.repository;

import com.example.mybatisStore.order.cart.entity.Cart;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CartMapper {

    // 장바구니에 물건을 추가 하는 로직
    @Insert("INSERT INTO carts (id, product_id, count) VALUES (#{id}, #{productId}, #{count})")
    void addCart(Cart cart);

}
