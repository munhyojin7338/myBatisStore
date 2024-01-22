package com.example.mybatisStore.order.entity;

import com.example.mybatisStore.store.entity.Store;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor // 빈 생성자
@AllArgsConstructor // 전체 생성자
@Getter
@Setter
public class Order {
    /*
    주문 내역 or 상품 주문 목록
    한 명의 USER는 여러 개의 주문을 넣을 수 있다.일대다(1:N)
    성공적으로 구매 했으면 Order
    구매 취소 실패 CANCEL
    반품 returns

     */

    private Long orderId;

    private Store store; // 상품 이름

    private LocalDateTime dateTime; // 주문일, 구매일


}
