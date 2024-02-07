package com.example.mybatisStore.store.entity;

import lombok.*;
    /*
     * 구현
        상품 생성
        업데이트
        상품 삭제
        category로 게시물 찾기
      , 낮은 가격
      , 높은 가격순으로 상품 찾기
      연관 된 상품 찾기 ex) iphone 검색 시 iphone 관련된 기종들이 다 검색 된다
     장바구니 담기

     */

/*
 * 미구현
 *   상품 구매순? , 상품 평점순
 *  상품 구매, 상품 취소, 상품 반품
 *  상품 평점
 */

@NoArgsConstructor // 빈 생성자
@AllArgsConstructor // 전체 생성자
@Getter
@Setter
@Builder // 빌더패턴
public class Store {

    private Long productId; // auto_increment 사용함 (MySQL)
    private String productName; // 상품명
    private CategoryEnum categoryEnum; // 카테고리 설정하기
    private String productContent;// 상품 설명 및 내용
    private String productImage; // 상품 이미지
    private String prices; // 가격
    private double totalScore; // total 점수
    private int countUser; // 평점을 남긴 회원 수
    private double averageScore; // 평균 점수

    public Store(Long productId, String productName, CategoryEnum categoryEnum
            , String productContent, String productImage, String prices) {
        this.productId = productId;
        this.productName = productName;
        this.categoryEnum = categoryEnum;
        this.productContent = productContent;
        this.productImage = productImage;
        this.prices = prices;
        this.totalScore = 0; // 초기값은 0으로 설정
        this.countUser = 0; // 초기값을 0으로 설정
        this.averageScore = 0; // 초기값을 0으로 설정
    }

    // Store 클래스에 countUser 필드 증가
    public void addRating(double rating) {
        // 5점 만점 중 유효한 평점인지 확인 후 총 점수 업데이트
        if (rating >= 0 && rating <= 5) {
            totalScore += rating;
            countUser++; // 평점을 남긴 사용자 수 증가
            calculateAverageScore(); // 평균 점수 다시 계산
        } else {
            System.out.println("유효하지 않은 평점입니다. 점수는 1.0 ~ 5.0점 가능합니다.");
        }
    }
    /* 평균 점수를 구하기 위한 로직 */
    public void calculateAverageScore() {
        if (countUser > 0) {
            averageScore = totalScore / countUser;
        } else {
            averageScore = 0; // 사용자가 아무도 점수를 남기지 않은 경우
        }
    }

    @Override
    public String toString() {
        return "Store {" +
                "productName = '" + productName + '\'' +
                ", categoryEnum = '" + categoryEnum + '\'' +
                ", productContent = '" + productContent + '\'' +
                ", productImage = '" + productImage + '\'' +
                ", prices = '" + prices + '\'' +
                ", totalScore = '" + totalScore + '\'' +
                ", countUser = '" + countUser + '\'' +
                ", averageScore = '" + averageScore + '\'' +
                '}';
    }
}
