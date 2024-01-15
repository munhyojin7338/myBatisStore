package com.example.mybatisStore.store.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor // 빈 생성자
@AllArgsConstructor // 전체 생성자
@Getter
@Builder // 빌더패턴
public class Store {

    private Long productId; // auto_increment 사용함 (MySQL)
    private String productName; // 상품명

    private String productContent;// 상품 설명 및 내용
    private String productImage; // 상품 이미지

    private String prices; // 가격

}
