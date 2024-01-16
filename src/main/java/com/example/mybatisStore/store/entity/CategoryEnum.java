package com.example.mybatisStore.store.entity;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CategoryEnum {

    CLOTHES("의류"),
    TOPS("상의", CLOTHES),
    BOTTOMS("하의", CLOTHES),
    SOCKS("양말", CLOTHES),

    ELECTRONIC_PRODUCT("전자제품"),
    TV("스마트티비", ELECTRONIC_PRODUCT),
    PHONE("스마트폰", ELECTRONIC_PRODUCT),
    REFRIGERATOR("냉장고", ELECTRONIC_PRODUCT),

    SHOES("신발"),
    SLIPPER("슬리퍼", SHOES),
    SANDAL("샌들",SHOES ),
    RUNNING("운동화",SHOES);


    private final String name;
    private final CategoryEnum parent;

    // 부모 없는 카테고리를 위한 생성자
    CategoryEnum(String name) {
        this.name = name;
        this.parent = null;
    }

}
