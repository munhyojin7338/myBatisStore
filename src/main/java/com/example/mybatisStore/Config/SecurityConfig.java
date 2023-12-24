package com.example.mybatisStore.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {

/*
업데이트

// before
.csrf().disable()
// after
.csrf(AbstractHttpConfigurer::disable) -> : Cross-Site Request Forgery (CSRF)
공격을 방지하기 위한 CSRF 보호를 비활성화합니다.


authorizeRequest() => authorizeHttpRequests()로 수정
antMatchers() => requestMatchers()로 수정
 */

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(( authorizeRequests)-> authorizeRequests
                        .anyRequest().permitAll())
                .formLogin(AbstractHttpConfigurer::disable)
                .sessionManagement((sessionManagement) ->
                        sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .httpBasic(withDefaults()); // HttpSecurity
        return http.build();
    }

}

