package com.example.mybatisStore.store.entity.dto;

import com.example.mybatisStore.store.entity.Store;
import com.example.mybatisStore.user.entity.User;
import lombok.*;

import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StoreRegisterDto {

    @NotNull
    private String productName; // 상품명

    @Lob // 대용량 데이터
    private String productContent; // 상품 내용

    private String productImage; // 상품 이미지

    @NotNull
    private String prices; // 가격

    @NotNull
    private User user; // 판매자

    public Store toEntity(){
        return new Store(productName, productContent,productImage,  prices, user);
    }
}
