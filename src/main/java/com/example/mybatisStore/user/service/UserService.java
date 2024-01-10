package com.example.mybatisStore.user.service;


import com.example.mybatisStore.user.entity.User;
import com.example.mybatisStore.user.entity.dto.UserSignup;
import com.example.mybatisStore.user.jwt.TokenInfo;

public interface UserService {
    Long getSignup(UserSignup userSignup); // 회원가입

    TokenInfo getLogin(String email, String password); // 로그인

    User getUserById(Long id); // 회원 정보 찾기
}
