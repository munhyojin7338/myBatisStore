package com.example.mybatisStore.user;


import com.example.mybatisStore.user.jwt.TokenInfo;

public interface UserService {
    Long getSignup(UserSignup userSignup);

    TokenInfo getLogin(String email, String password);
}
