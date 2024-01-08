package com.example.mybatisStore.store.dto;


import com.example.mybatisStore.store.Store;
import lombok.*;

@Builder
@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StoreResponseDto {

    private String productName; // 상품명

    private String productImage; // 상품 이미지

    private String prices; // 가격

    public StoreResponseDto(Store store){
        this.productName = store.getProductName();
        this.productImage = store.getProductImage();
        this.prices = store.getPrices();
    }

}
