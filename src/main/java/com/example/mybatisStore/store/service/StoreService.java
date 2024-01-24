package com.example.mybatisStore.store.service;

import com.example.mybatisStore.store.entity.CategoryEnum;
import com.example.mybatisStore.store.entity.Store;
import com.example.mybatisStore.store.entity.dto.StoreRegisterDto;
import com.example.mybatisStore.store.entity.dto.StoreUpdateDto;
import com.example.mybatisStore.store.repository.StoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StoreService {

    private final StoreMapper storeMapper;


    @Autowired
    public StoreService(StoreMapper storeMapper) {
        this.storeMapper = storeMapper;
    }

    // 상품 Id를 찾는 로직
    public void findByproductId(Long productId){
        storeMapper.findById(productId);
    }

    public void addStore(StoreRegisterDto storeRegisterDto) {
        Store store = storeRegisterDto.toEntity();
        storeMapper.createStore(store);
    }

    public void updateStore(StoreUpdateDto updateDto) {
        storeMapper.upStore(updateDto);
    }

    public void deleteStore(Long productId) {
        Store store = Store.builder()
                .productId(productId)
                .build();
        storeMapper.deStore(store);
    }

    // 카테고리로 상품 찾기
    public List<Store> getStoresByCategory(CategoryEnum categoryEnum) {
        return storeMapper.findByCategory(categoryEnum);
    }

    // 낮은 가격순으로 찾기
    public List<Store> categoryAndLowerPrice(CategoryEnum categoryEnum) {
        return storeMapper.getLowerPrice(categoryEnum);
    }

    // 높은 가격순으로 찾기
    public List<Store> categoryAndHigherPrice(CategoryEnum categoryEnum) {
        return storeMapper.getHighPrice(categoryEnum);
    }

    // 상품 구매 후 총 점수 남기기
    public void totalProduct(Long productId, double userRating) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("productId", productId);
        paramMap.put("userRating", userRating);

        storeMapper.total(paramMap);
    }

//    public void rateProduct(Long productId, double userRating) {
//        Store store = storeMapper.findById(productId); // 예시로 상품 조회 메서드 사용
//        store.setProductId(productId);
//        store.setAverageRating(userRating);
//        storeMapper.rate(store);
//    }



}
