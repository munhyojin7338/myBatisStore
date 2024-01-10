package com.example.mybatisStore.store.service;

import com.example.mybatisStore.store.Store;
import com.example.mybatisStore.store.dto.StoreRegisterDto;

public interface StoreService {

    Long getCreate(Long userId, StoreRegisterDto registerDto);

    Store getProductById(Long productId);
}
