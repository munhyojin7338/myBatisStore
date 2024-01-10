package com.example.mybatisStore.store;

import com.example.mybatisStore.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(nullable = false, length = 50)
    private String productName; // 상품명

    @Column // 대용량 데이터
    private String productContent;// 상품 설명 및 내용

    @Column
    private String productImage; // 상품 이미지


    @Column(nullable = false, length = 50)
    private String prices; // 가격

    @ManyToOne(fetch = FetchType.EAGER) // 연관관계 Many = store, One = User
    @JoinColumn(name = "userId")
    private User user; // 글을 작성한 판매자 id,





    public Store(String productName, String productContent,String productImage,  String prices) {
        this.productName = productName;
        this.productContent = productContent;
        this.productImage = productImage;
        this.prices = prices;
    }



}
