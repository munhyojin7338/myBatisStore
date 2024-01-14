package com.example.mybatisStore.store.service;

import com.example.mybatisStore.store.entity.Store;
import com.example.mybatisStore.store.entity.dto.StoreRegisterDto;
import com.example.mybatisStore.store.repository.StoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
