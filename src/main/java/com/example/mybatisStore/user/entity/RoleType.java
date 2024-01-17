package com.example.mybatisStore.user.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RoleType {

    USER("일반 유저")
    ,ADMIN("관리자");

    private final String name;


}
