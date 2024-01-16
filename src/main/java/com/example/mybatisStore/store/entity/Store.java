package com.example.mybatisStore.store.entity;

import lombok.*;

@NoArgsConstructor // 빈 생성자
@AllArgsConstructor // 전체 생성자
@Getter
@Setter
@Builder // 빌더패턴
public class Store {

    private Long productId; // auto_increment 사용함 (MySQL)
    private String productName; // 상품명
    private CategoryEnum categoryEnum; // 카테고리 설정하기
    private String productContent;// 상품 설명 및 내용
    private String productImage; // 상품 이미지

    private String prices; // 가격

}
