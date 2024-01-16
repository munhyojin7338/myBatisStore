package com.example.mybatisStore.store.repository;

import com.example.mybatisStore.store.entity.Store;
import com.example.mybatisStore.store.entity.dto.StoreUpdateDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;


@Mapper //  MyBatis의 Mapper 인터페이스로서 동작하도록 지정합니다.
public interface StoreMapper {

    /*
    @Insert: MyBatis에서 이 어노테이션은 데이터를 삽입하는 SQL을 지정
    여기서는 store 테이블에 데이터를 추가하는 쿼리를 정의
    CREATE
     */
    @Insert("INSERT INTO store (product_name, product_content, product_image, prices) " +
            "VALUES (#{productName}, #{productContent}, #{productImage}, #{prices})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "productId", before = false, resultType = Long.class)
    void createStore(Store store);

    /*
    READ
     */

    /*
    productId가 일치하게 된다면 게시물 수정 가능, UPDATE
     */
    @Update("UPDATE store " +
            "SET product_name = #{productName}, " +
            "product_content = #{productContent}, " +
            "product_image = #{productImage}, " +
            "prices = #{prices} " +
            "WHERE product_id = #{productId}")
    void upStore(StoreUpdateDto updateDto);

}
