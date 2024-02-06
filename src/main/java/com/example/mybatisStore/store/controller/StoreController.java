package com.example.mybatisStore.store.controller;


import com.example.mybatisStore.store.entity.dto.StoreRegisterDto;
import com.example.mybatisStore.store.entity.dto.StoreUpdateDto;
import com.example.mybatisStore.store.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StoreController {

    private final StoreService storeService;


    @Autowired
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    // 상품 추가
    @PostMapping("/add")
    public void addStore(@RequestBody StoreRegisterDto storeRegisterDto) {
        storeService.addStore(storeRegisterDto);
    }

    // 상품 수정
    @PutMapping("/update")
    public void updateStore(@RequestBody StoreUpdateDto updateDto) {
        storeService.updateStore(updateDto);
    }

    // 상품 삭제
    @DeleteMapping("/delete/{productId}")
    public void deleteStore(@PathVariable Long productId) {
        storeService.deleteStore(productId);
    }

    // 점수 남기기
    @PostMapping("/store/{productId}/rating")
    public void addRating(@PathVariable Long productId, @RequestBody double rating) {
        storeService.addRating(productId, rating);
    }

}
