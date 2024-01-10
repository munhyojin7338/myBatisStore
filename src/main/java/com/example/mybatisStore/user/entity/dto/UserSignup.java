package com.example.mybatisStore.user.entity.dto;


import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserSignup {

    @NotBlank(message = "이름을 입력하세요")
    private String username;

    @NotBlank(message = "email를 입력해주세요")
    private String email;

    @NotBlank(message = "password를 입력해주세요")
    @Pattern(regexp = "^[ㄱ-ㅎ가-힣a-z0-9-_]{2,10}$", message = "password는 특수문자를 포함 2~10자 입니다.")
    private String password;

    @NotBlank(message = "전화번호를 입력해 주세요!")
    @Pattern(regexp = "^01(?:0|1|0)[.-]?(\\d{3}|\\d{4})[.-]?(\\d{4})$", message = "10 ~ 11 자리의 숫자만 입력 가능합니다.")
    private String phone;

    @NotBlank(message = "나이를 입력해주세요")
    private String age;

    // Blank 가능
    private String address;

}
