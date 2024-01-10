package com.example.mybatisStore.store;

import com.example.mybatisStore.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@NoArgsConstructor // 빈 생성자
@AllArgsConstructor // 전체 생성자
@Getter
@Builder // 빌더패턴
public class Store {
    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId; // auto_increment 사용함 (MySQL)

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

    public Store(String productName, String productContent,String productImage,  String prices, User user) {
        this.productName = productName;
        this.productContent = productContent;
        this.productImage = productImage;
        this.prices = prices;
        this.user = user;
    }



}
