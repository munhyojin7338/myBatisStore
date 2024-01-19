package com.example.mybatisStore.cart.entity;


import com.example.mybatisStore.store.entity.Store;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder // 빌더 패턴
@NoArgsConstructor // 빈 생성자
@AllArgsConstructor // 전체 생성자
public class CartList {

    /*

     1. 하나의 장바구니(Cart)에 여러 개의 장바구니_상품(Cart_List)을 담을 수 있다
    다대일 매핑

    2. 상품(Store) 엔티티 하나의 상품이 여러 장바구니 상품으로 담길 수 있다
    다대일 매핑

     */
    private Long cartListId; // PK

    private Cart cart; // N : 1 다대일 매핑 구조 , FK

    private Store store; // N : 1 다대일 매핑 구조 , FK

    private int count;
}
