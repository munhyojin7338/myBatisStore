package com.example.mybatisStore.store.controller;

import com.example.mybatisStore.store.entity.CategoryEnum;
import com.example.mybatisStore.store.entity.Store;
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

    private static final Logger logger = LoggerFactory.getLogger(StoreApiController.class);

    @GetMapping("/findByCategory/{category}")
    public List<Store> getStoresByCategory(@PathVariable String category) {
        CategoryEnum categoryEnum = CategoryEnum.valueOf(category.toUpperCase());
        List<Store> stores = storeService.getStoresByCategory(categoryEnum);
        logger.info("카테고리 설정 완료 {}: {}", categoryEnum, stores);
        return stores;
    }

    // 낮은 가격순
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

    // 높은 가격순
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

    // 연관 상품
    @GetMapping("/productName/{productName}")
    public ResponseEntity<List<Store>> searchProductName(@PathVariable("productName") String productName) {
        try {
            List<Store> stores = storeService.partialTextSearch(productName);
            logger.info("이름 {} 연관 된 이름 정렬 : {}", productName, stores);
            return new ResponseEntity<>(stores, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("검색 중에 오류가 발생했습니다. 검색어: {}", productName, e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 평점 높은순
    @GetMapping("/averageScore/{category}/higher")
    public ResponseEntity<List<Store>> getAverageHigh(@PathVariable("category") CategoryEnum categoryEnum) {
        try {
            List<Store> stores = storeService.averageHigher(categoryEnum);
            if (stores != null && !stores.isEmpty()) { // stores가 null이 아니고 비어 있지 않은 경우에만 처리
                logger.info("평점 설정 후 {} 높은 평점 순 : {}", categoryEnum, stores);
                return new ResponseEntity<>(stores, HttpStatus.OK);
            } else {
                logger.info("{} 카테고리에 대한 상점이 없습니다.", categoryEnum);
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 상점이 없는 경우 404 에러 반환
            }
        } catch (Exception e) {
            logger.error("상점 조회 중 오류 발생: {}", e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 평점 낮은순
    @GetMapping("/averageScore/{category}/lower")
    public ResponseEntity<List<Store>> getAveragerLow(@PathVariable("category") CategoryEnum categoryEnum) {
        try {
            List<Store> stores = storeService.averageLower(categoryEnum);
            if (stores != null && !stores.isEmpty()) { // stores가 null이 아니고 비어 있지 않은 경우에만 처리
                logger.info("평점 설정 후 {} 낮은 평점 순 : {}", categoryEnum, stores);
                return new ResponseEntity<>(stores, HttpStatus.OK);
            } else {
                logger.info("{} 카테고리에 대한 상점이 없습니다.", categoryEnum);
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 상점이 없는 경우 404 에러 반환
            }
        } catch (Exception e) {
            logger.error("상점 조회 중 오류 발생: {}", e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
