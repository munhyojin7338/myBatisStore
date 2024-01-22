package com.example.mybatisStore.order.cart.repository;

import com.example.mybatisStore.order.cart.entity.Cart;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CartMapper {
    @Insert("INSERT INTO carts (id, product_id, count) VALUES (#{user.id}, #{store.productId}, #{count})")
    void addCart(Cart cart);

}
