package com.example.mybatisStore.store.dto;

import com.example.mybatisStore.store.Store;
import com.example.mybatisStore.user.User;
import lombok.*;

import javax.persistence.Lob;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StoreRegisterDto {

    @NonNull
    private String productName; // 상품명

    @Lob // 대용량 데이터
    private String productContent; // 상품 내용

    private String productImage; // 상품 이미지

    @NonNull
    private String prices; // 가격

    @NonNull
    private String userId; // 판매자

    public Store toEntity(){
        return new Store(productName, productContent,productImage,  prices);
    }
}
