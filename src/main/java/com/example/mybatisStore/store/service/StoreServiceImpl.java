package com.example.mybatisStore.store.service;


import com.example.mybatisStore.store.Store;
import com.example.mybatisStore.store.StoreRepository;
import com.example.mybatisStore.store.dto.StoreRegisterDto;
import com.example.mybatisStore.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService{
    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public Long getCreate(StoreRegisterDto registerDto, User user) {
        Store store = Store.builder()
                .user(registerDto.getUser())
                .productName(registerDto.getProductName())
                .productImage(registerDto.getProductImage())
                .build();
        storeRepository.save(store);
        return null;
    }
}
