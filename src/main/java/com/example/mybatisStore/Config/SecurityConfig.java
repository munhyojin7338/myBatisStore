package com.example.mybatisStore.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws  Exception {
        // 권한에 따라 허용하는 url 설정
        // login, signup 페이지는 모두 허용, 다른 페이지는 인증된 사용자만 허용
        return http.build();

    }
}
