package com.example.mybatisStore.store.entity.dto;

import com.example.mybatisStore.store.entity.Store;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StoreRegisterDto {

    @NotNull
    private String productName; // 상품명

    private String productContent; // 상품 내용

    private String productImage; // 상품 이미지

    @NotNull
    private String prices; // 가격


    public Store toEntity() {
        return Store.builder()
                .productName(productName)
                .productContent(productContent)
                .productImage(productImage)
                .prices(prices)
                .build();
    }
}