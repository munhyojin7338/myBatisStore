package com.example.mybatisStore.store;

import com.example.mybatisStore.user.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "productId", nullable = false)
    private Long productId;

    @Column
    private String productName; // 상품명

    @Column
    private String productImage; // 상품 이미지

    @Column
    private String prices; // 가격

    @Column
    private LocalDateTime localDateTime; // 생성된 time

    @ManyToOne
    @JoinColumn(name = "id")
    private User user;



}
