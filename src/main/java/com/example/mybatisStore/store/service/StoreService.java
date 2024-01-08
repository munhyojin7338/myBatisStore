package com.example.mybatisStore.store.service;

import com.example.mybatisStore.store.dto.StoreRegisterDto;
import com.example.mybatisStore.user.User;

public interface StoreService {

    Long getCreate(StoreRegisterDto registerDto, User user);
}
