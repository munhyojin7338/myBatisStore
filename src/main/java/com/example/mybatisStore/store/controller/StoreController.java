package com.example.mybatisStore.store.controller;


import com.example.mybatisStore.store.entity.dto.StoreRegisterDto;
import com.example.mybatisStore.store.entity.dto.StoreUpdateDto;
import com.example.mybatisStore.store.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreController {

    private final StoreService storeService;

    @Autowired
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @PostMapping("/add")
    public void addStore(@RequestBody StoreRegisterDto storeRegisterDto) {
        storeService.addStore(storeRegisterDto);
    }

    @PutMapping("/update")
    public void updateStore(@RequestBody StoreUpdateDto updateDto) {
        storeService.updateStore(updateDto);
    }
}
