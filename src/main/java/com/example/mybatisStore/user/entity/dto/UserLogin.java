package com.example.mybatisStore.user.entity.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Email;

@Builder
@Getter
public class UserLogin {

    @Email
    private String email;
    private String password;
}
