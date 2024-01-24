package com.example.mybatisStore.store.entity;

import lombok.*;

@NoArgsConstructor // 빈 생성자
@AllArgsConstructor // 전체 생성자
@Getter
@Setter
@Builder // 빌더패턴
public class Store {
    /*
     * 구현
         상품 생성 , 업데이트 , 상품 삭제
        category로 게시물 찾기
     , 낮은 가격, 높은 가격순으로 상품 찾기
     장바구니 담기

     */


    /*
     * 미구현
     *   상품 구매순? , 상품 평점순
     *  상품 구매, 상품 취소, 상품 반품
     *  상품 평점
     */

    private Long productId; // auto_increment 사용함 (MySQL)
    private String productName; // 상품명
    private CategoryEnum categoryEnum; // 카테고리 설정하기
    private String productContent;// 상품 설명 및 내용
    private String productImage; // 상품 이미지
    private String prices; // 가격

    private double numOfRatings = 0.0;  // 평점을 준 사용자 수

    private double totalRating = 0.0;  // 총 합계

    private double averageRating = 0.0;  // 평균 평점

    @Override
    public String toString() {
        return "Store {" +
                "productName = '" + productName + '\'' +
                ", categoryEnum = '" + categoryEnum + '\'' +
                ", productContent = '" + productContent + '\'' +
                ", productImage = '" + productImage + '\'' +
                ", prices = '" + prices + '\'' +
                ", averageRating = '" + averageRating + '\'' +
                '}';

    }
}
