package com.example.mybatisStore.order;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum OrderStatus {
    /*
    한명의 회원은 여러 개의 주문을 넣을 수 있다.
    주문 상태를 나타내는 OrderStatus enum class를 만들었고
    주문을 한 상태는 Order, 주문 취소 상태는 Cancel이라고 나타냄
     */
    ORDER("주문")
    , CANCEL("취소");

    private final String name;
}
