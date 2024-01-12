package com.example.mybatisStore.store.repository;

import com.example.mybatisStore.store.entity.Store;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

// mapper -> service, repository
@Mapper
@Repository
public interface StoreMapper {

    void createStore(Store store); // 게시판 생성

}
