package com.example.mybatisStore.order.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor // 빈 생성자
@AllArgsConstructor // 전체 생성자
@Getter
@Setter
public class Order {
    /*
    한명의 회원은 여러 개의 주문을 넣을 수 있다.
    주문 엔티티 기준에서 다대일 (N:1) 단방향 매핑을 진행
     */

    private Long orderId;

}
