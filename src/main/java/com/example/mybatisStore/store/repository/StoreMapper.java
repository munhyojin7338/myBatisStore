package com.example.mybatisStore.store.repository;

import com.example.mybatisStore.store.entity.Store;
import org.apache.ibatis.annotations.Mapper;

// mapper -> service, repository
@Mapper
public interface StoreMapper {
    void createStore(Store store);
}
