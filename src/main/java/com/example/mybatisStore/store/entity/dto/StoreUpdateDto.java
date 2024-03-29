package com.example.mybatisStore.store.entity.dto;

import com.example.mybatisStore.store.entity.CategoryEnum;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StoreUpdateDto {

    @NotNull
    private Long productId;

    private String productName;

    private CategoryEnum categoryEnum;

    private String productContent;

    private String productImage; // 수정할 상품 이미지

    private String prices;
}
