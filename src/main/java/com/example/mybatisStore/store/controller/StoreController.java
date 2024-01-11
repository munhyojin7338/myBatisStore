package com.example.mybatisStore.store.controller;


import com.example.mybatisStore.store.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StoreController {


    private StoreService storeService;



}
