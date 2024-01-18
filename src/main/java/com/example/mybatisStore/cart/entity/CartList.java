package com.example.mybatisStore.cart.entity;


import com.example.mybatisStore.store.entity.Store;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Builder // 빌더 패턴
@NoArgsConstructor // 빈 생성자
@AllArgsConstructor // 전체 생성자
public class CartList {

    /*

    1. 하나의 장바구니에 여러 개의 상품을 담을 수 있다
    다대일 매핑

    2. 상품 엔티티 하나의 상품이 여러 장바구니 상품으로 담길 수 있다
    다대일 매핑

     */
    private Long cartListId;

    private Cart cart;


    private Store store;

    private int count;
}
