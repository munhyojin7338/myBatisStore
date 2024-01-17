package com.example.mybatisStore.store.controller;

import com.example.mybatisStore.store.entity.CategoryEnum;
import com.example.mybatisStore.store.entity.Store;
import com.example.mybatisStore.store.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StoreApiController {

    private final StoreService storeService;
    private static final Logger logger = LoggerFactory.getLogger(StoreApiController.class);
    @GetMapping("/findByCategory/{category}")
    public List<Store> getStoresByCategory(@PathVariable String category) {
        CategoryEnum categoryEnum = CategoryEnum.valueOf(category.toUpperCase());
        List<Store> stores = storeService.getStoresByCategory(categoryEnum);
        logger.info("Stores found for category {}: {}", categoryEnum, stores);
        return stores;
    }
}
