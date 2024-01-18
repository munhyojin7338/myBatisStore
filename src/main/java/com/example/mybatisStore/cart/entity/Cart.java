package com.example.mybatisStore.cart.entity;


import com.example.mybatisStore.user.entity.User;
import lombok.*;

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
public class Cart {


    private Long cartId; // auto_increment 사용함 (MySQL)

    private Long id; // 이 부분이 User의 Id를 참조하는 외래 키

    private User user; // User 관계
}
