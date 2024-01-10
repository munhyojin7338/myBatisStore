package com.example.mybatisStore.store.controller;


import com.example.mybatisStore.store.Store;
import com.example.mybatisStore.store.StoreRepository;
import com.example.mybatisStore.store.dto.StoreRegisterDto;
import com.example.mybatisStore.store.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class StoreController {
    private final StoreService storeService;

    private final StoreRepository storeRepository;

    @PostMapping("/Create")
    public ResponseEntity<?> createStore(@RequestBody @Valid Long userId, StoreRegisterDto storeRegisterDto) {
        Long productId = storeService.getCreate(userId, storeRegisterDto);
        return ResponseEntity.ok(productId);
    }

    @GetMapping("/product/{productId}")
    public Store detail(@PathVariable Long productId) {
        return storeService.getProductById(productId);
    }
}
