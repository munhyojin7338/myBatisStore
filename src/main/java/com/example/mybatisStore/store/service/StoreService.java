package com.example.mybatisStore.store.service;

import com.example.mybatisStore.store.dto.StoreRegisterDto;
import com.example.mybatisStore.user.User;
import org.springframework.security.core.Authentication;

public interface StoreService {

    Long getCreate(StoreRegisterDto registerDto);
}
