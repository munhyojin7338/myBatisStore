package com.example.mybatisStore.store.controller;


import com.example.mybatisStore.store.entity.Store;
import com.example.mybatisStore.store.entity.dto.StoreRegisterDto;
import com.example.mybatisStore.store.entity.dto.StoreUpdateDto;
import com.example.mybatisStore.store.service.StoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StoreController {

    private final StoreService storeService;
    private static final Logger logger = LoggerFactory.getLogger(StoreController.class);

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

    @DeleteMapping("/delete/{productId}")
    public void deleteStore(@PathVariable Long productId) {
        storeService.deleteStore(productId);
    }

//    @PostMapping("/rateProduct/{productId}/{userRating}")
//    public ResponseEntity<String> rateProduct(@PathVariable Long productId, @PathVariable double userRating) {
//        try {
//            storeService.rateProduct(productId, userRating);
//            return ResponseEntity.ok("평점이 성공적으로 등록되었습니다.");
//        } catch (Exception e) {
//            // 예외 발생 시 로깅
//            logger.error("평점 등록 중 오류가 발생했습니다. 상품 ID: {}, 평점: {}", productId, userRating, e);
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("평점 등록 중 오류가 발생했습니다.");
//        }
//    }



}
