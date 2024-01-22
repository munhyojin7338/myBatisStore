package com.example.mybatisStore.order.cart.entity;


import com.example.mybatisStore.store.entity.Store;
import com.example.mybatisStore.user.entity.User;
import lombok.*;

import javax.persistence.Table;

/*
User - Cart는 1:1 관계
Cart(장바구니)에는 여러개의 상품을 담을 수 있으므로 그것을 담을 수 있는 객체가 필요
장바구니 엔티티가 회원 엔티티를 참조하는 일대일 단방향 매핑
 */
@NoArgsConstructor // 빈 생성자
@AllArgsConstructor // 전체 생성자
@Getter
@Setter
@Builder // 빌더패턴
@Table(name = "carts")
public class Cart {
    /*
    상품 Store 상세 페이지 이동-> 상품 개수 선택 -> 상품 구매 사이트 이동(구매자, 상품명 , 상품 가격, 상품 개수 )
    or 장바구니 담기(구매자, 상품명 , 상품 가격, 상품 개수 )
        -> 상품 구매 페이지 이동 -> 상품명, 개수, 가격 확인 후 결제
        -> 장바구니 담기 -> 장바구니 페이지 이동 -> 장바구니에 담겨 있는 모든 제품, 개수
        장바구니 페이지에는 구매자, 상품명 , 상품 가격, 상품 개수이 담겨있다
     */



    private Long cartId; // auto_increment 사용함 (MySQL)

    private Long id; // 이 부분이 User의 Id를 참조하는 외래 키

    private Long productId; // 이 부분은 Store Id를 참조하는 외래 키

    private String count; // 상품 개수

    private User user; // 유저+

    private Store store; // 상품
}
