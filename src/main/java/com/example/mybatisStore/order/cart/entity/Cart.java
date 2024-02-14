package com.example.mybatisStore.order.cart.entity;


import com.example.mybatisStore.store.entity.Store;
import com.example.mybatisStore.user.entity.User;
import lombok.*;

import javax.persistence.Table;
import java.math.BigDecimal;

/*
User - Cart는 1:1 관계
Cart(장바구니)에는 여러개의 상품을 담을 수 있으므로 그것을 담을 수 있는 객체가 필요
장바구니 엔티티가 회원 엔티티를 참조하는 일대일 단방향 매핑
 */
@NoArgsConstructor // 빈 생성자
@AllArgsConstructor // 전체 생성자
@Setter
@Getter
@Table(name = "carts")
public class Cart {

    private Long cartId; // auto_increment 사용함 (MySQL)

    private Long id; // 이 부분이 User의 Id를 참조하는 외래 키

    private Long productId; // 이 부분은 Store Id를 참조하는 외래 키

    private int count; // 상품 개수

    private User user; // 유저

    private Store store; // 상품

    private String prices; // 상품 총 가격

}