package com.example.mybatisStore.store.repository;

import com.example.mybatisStore.store.entity.CategoryEnum;
import com.example.mybatisStore.store.entity.Store;
import com.example.mybatisStore.store.entity.dto.StoreUpdateDto;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;


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
    상품 삭제
     */
    @Delete("DELETE FROM store WHERE product_id = #{productId}")
    void deStore(Store store);

    @Select("SELECT * FROM store WHERE product_id = #{productId}")
    void findById(Long productId);

    /*
    카테고리로 상품을 찾을 수 있게 만들기
     */
    @Select("SELECT * FROM store WHERE category_enum = #{categoryEnum}")
    List<Store> findByCategory(@Param("categoryEnum")CategoryEnum categoryEnum);

    /*
        카테고리 설정 후 낮은 가격순 확인하기
     */
    @Select("SELECT * FROM store WHERE category_enum = #{categoryEnum} ORDER BY prices ASC")
    List<Store> getLowerPrice(@Param("categoryEnum") CategoryEnum categoryEnum);

    /*
        카테고리 설정 후 높은 가격순으로 확인하기
     */
    @Select("SELECT * FROM store WHERE category_enum = #{categoryEnum} ORDER BY prices DESC")
    List<Store> getHighPrice(@Param("categoryEnum") CategoryEnum categoryEnum);

    // 상품 구매 후 평점 남기기
    @Update("UPDATE store " +
            "SET total_rating = total_rating + #{userRating}, " +
            "num_of_ratings = num_of_ratings + 1 " +
            "WHERE product_id = #{productId}")
    void total(Map<String, Object> paramMap);



    @Update("UPDATE store " +
            "SET total_rating = total_rating + #{userRating}, " +
            "num_of_ratings = num_of_ratings + 1, " +
            "average_rating = (total_rating + #{userRating}) / (num_of_ratings + 1) " +
            "WHERE product_id = #{productId}")
    void rate(Store store);

}
