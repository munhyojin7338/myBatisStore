package com.example.mybatisStore.user;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserLogin {
    private String email;
    private String password;
}
