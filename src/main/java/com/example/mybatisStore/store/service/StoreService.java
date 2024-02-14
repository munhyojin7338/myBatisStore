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

    public void addStore(StoreRegisterDto storeRegisterDto) {
        Store store = storeRegisterDto.toEntity();
        storeMapper.createStore(store);
    }

    public void updateStore(StoreUpdateDto updateDto) {
        storeMapper.upStore(updateDto);
    }

    // 게시물 삭제
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

    // 연관 검색으로 상품 찾아보기
    public List<Store> partialTextSearch(String productName) {
        return storeMapper.textSearch(productName);
    }

    // 상품 총(합) 점수 후 평균 점수까지 계산하기
    public void addRating(Long productId, double rating) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("rating", rating);
        parameters.put("productId", productId);
        storeMapper.addRating(parameters);

        // 총(합) 점수를 남기기 위한 로직
        Store store = storeMapper.findById(productId);
        store.addRating(rating);
    }

    // 높은 평점부터 불러오기
    public List<Store> averageHigher(CategoryEnum categoryEnum){
        return storeMapper.getAverageHigher(categoryEnum);
    }

    // 낮은 평점부터 불러오기
    public List<Store> averageLower(CategoryEnum categoryEnum) {
        return storeMapper.getAverageLower(categoryEnum);
    }

}
