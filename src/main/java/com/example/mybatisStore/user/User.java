package com.example.mybatisStore.user;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String username;
    private String email; // 로그인 할 때 ID
    private String password;
    private String phone;
    private String age;
    private String address;
}
