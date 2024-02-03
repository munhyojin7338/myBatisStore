package com.example.mybatisStore.store.controller;

import com.example.mybatisStore.store.entity.CategoryEnum;
import com.example.mybatisStore.store.entity.Store;
import com.example.mybatisStore.store.repository.StoreMapper;
import com.example.mybatisStore.store.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StoreApiController {

    private final StoreService storeService;

    private final StoreMapper storeMapper;


    private static final Logger logger = LoggerFactory.getLogger(StoreApiController.class);

    @GetMapping("/findByCategory/{category}")
    public List<Store> getStoresByCategory(@PathVariable String category) {
        CategoryEnum categoryEnum = CategoryEnum.valueOf(category.toUpperCase());
        List<Store> stores = storeService.getStoresByCategory(categoryEnum);
        logger.info("카테고리 설정 완료 {}: {}", categoryEnum, stores);
        return stores;
    }

    @GetMapping("/category/{category}/lower-price")
    public ResponseEntity<List<Store>> getStoresByCategoryAndLowerPrice(@PathVariable("category") CategoryEnum categoryEnum) {
        try {
            List<Store> stores = storeService.categoryAndLowerPrice(categoryEnum);
            logger.info("카테고리 설정 후 {} 낮은 가격 순 : {}", categoryEnum, stores);
            return new ResponseEntity<>(stores, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/category/{category}/higher-price")
    public ResponseEntity<List<Store>> getStoresByCategoryAndHigherPrice(@PathVariable("category") CategoryEnum categoryEnum){
        try {
            List<Store> stores = storeService.categoryAndHigherPrice(categoryEnum);
            logger.info("카테고리 설정 후 {} 높은 가격 순 : {}", categoryEnum, stores);
            return new ResponseEntity<>(stores, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
