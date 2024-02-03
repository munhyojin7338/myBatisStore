package com.example.mybatisStore.store.service;

import com.example.mybatisStore.store.entity.CategoryEnum;
import com.example.mybatisStore.store.entity.Store;
import com.example.mybatisStore.store.entity.dto.StoreRegisterDto;
import com.example.mybatisStore.store.entity.dto.StoreUpdateDto;
import com.example.mybatisStore.store.repository.StoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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




}
