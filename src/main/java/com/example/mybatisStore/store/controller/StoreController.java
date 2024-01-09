package com.example.mybatisStore.store.controller;


import com.example.mybatisStore.store.dto.StoreRegisterDto;
import com.example.mybatisStore.store.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class StoreController {
    private final StoreService storeService;


    @PostMapping("/Create")
    public ResponseEntity<?> createStore(@RequestBody @Valid StoreRegisterDto storeRegisterDto) {
        Long productId = storeService.getCreate(storeRegisterDto);
        return ResponseEntity.ok(productId);
    }
}
