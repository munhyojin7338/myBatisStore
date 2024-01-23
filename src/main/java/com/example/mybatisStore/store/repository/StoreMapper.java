package com.example.mybatisStore.store.repository;

import com.example.mybatisStore.store.entity.CategoryEnum;
import com.example.mybatisStore.store.entity.Store;
import com.example.mybatisStore.store.entity.dto.StoreUpdateDto;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper //  MyBatis의 Mapper 인터페이스로서 동작하도록 지정합니다.
public interface StoreMapper {

    /*
    @Insert: MyBatis에서 이 어노테이션은 데이터를 삽입하는 SQL을 지정
    여기서는 store 테이블에 데이터를 추가하는 쿼리를 정의
    CREATE
     */
    @Insert("INSERT INTO store (product_name, category_enum, product_content, product_image, prices) " +
            "VALUES (#{productName}, #{categoryEnum}, #{productContent}, #{productImage}, #{prices})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "productId", before = false, resultType = Long.class)
    void createStore(Store store);


    /*
    productId가 일치하게 된다면 게시물 수정 가능, UPDATE
     */
    @Update("UPDATE store " +
            "SET product_name = #{productName}, " +
            "category_enum = #{categoryEnum}, "  +
            "product_content = #{productContent}, " +
            "product_image = #{productImage}, " +
            "prices = #{prices} " +
            "WHERE product_id = #{productId}")
    void upStore(StoreUpdateDto updateDto);


    /*
    카테고리로 상품을 찾을 수 있게 만들기
     */
    @Select("SELECT * FROM store WHERE category_enum = #{categoryEnum}")
    List<Store> findByCategory(@Param("categoryEnum")CategoryEnum categoryEnum);


    /*
        카테고리로 별로 상품을 찾고 그 중에서 낮은 가격순으로 확인해보기
     */
    @Select("SELECT * FROM store WHERE category_enum = #{categoryEnum} ORDER BY prices ASC")
    List<Store> getLowerPrice(@Param("categoryEnum") CategoryEnum categoryEnum);

}
