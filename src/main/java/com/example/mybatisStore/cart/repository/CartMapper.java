package com.example.mybatisStore.cart.repository;

import com.example.mybatisStore.cart.entity.Cart;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CartMapper {

    @Insert("INSERT INTO carts (id) VALUES (#{id})")
    void insertCart(Cart cart);

}
