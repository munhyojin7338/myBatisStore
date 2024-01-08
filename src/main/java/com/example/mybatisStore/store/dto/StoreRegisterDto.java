package com.example.mybatisStore.store.dto;

import com.example.mybatisStore.store.Store;
import com.example.mybatisStore.user.User;
import lombok.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StoreRegisterDto {

    private String productName; // 상품명

    private String productImage; // 상품 이미지

    private String prices; // 가격

    private User user;

    public Store toEntity(){
        return new Store(productName, productImage,  prices);
    }
}
