package com.example.mybatisStore.user.controller;

import com.example.mybatisStore.user.entity.dto.UserLogin;
import com.example.mybatisStore.user.entity.dto.UserSignup;
import com.example.mybatisStore.user.jwt.TokenInfo;
import com.example.mybatisStore.user.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.servlet.http.Cookie;


@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup") // 회원가입 검증 로직  -> 이미 회원가입 된 로직인지 확인(완료), 누구나 접근 가능
    public ResponseEntity<?> signup(@RequestBody @Valid UserSignup userSignup) {
        Long userId = userService.getSignup(userSignup);
        return ResponseEntity.ok(userId);
    }

    @PostMapping("/login") // 로그인, 누구나 접근 가능
    public ResponseEntity<?> login(@RequestBody @Valid UserLogin userLogin
            , HttpServletResponse response) {
        TokenInfo tokenInfo = userService.getLogin(userLogin.getEmail(), userLogin.getPassword());
        addTokenToCookies(response, tokenInfo);
        return ResponseEntity.ok(tokenInfo);
    }

    private void addTokenToCookies(HttpServletResponse response, TokenInfo tokenInfo) {
        Cookie jwtCookie = new Cookie("jwtToken", tokenInfo.getAccessToken());
        Cookie idCookie = new Cookie("myId", tokenInfo.getAccessToken());

        setCookiePath(jwtCookie);
        setCookiePath(idCookie);

        response.addCookie(jwtCookie);
        response.addCookie(idCookie);
    }

    private void setCookiePath(Cookie cookie) {
        cookie.setPath("/");
    }


}
