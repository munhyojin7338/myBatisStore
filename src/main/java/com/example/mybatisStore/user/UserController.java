package com.example.mybatisStore.user;

import com.example.mybatisStore.user.jwt.TokenInfo;
import com.example.mybatisStore.user.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup") // 회원가입 검증 로직  -> 이미 회원가입 된 로직인지 확인
    public ResponseEntity<?> signup(@RequestBody @Valid UserSignup userSignup) {
        Long userId = userService.getSignup(userSignup);
        return ResponseEntity.ok(userId);
    }

    @PostMapping("/login") // 로그인
    /*
    로그인 검증 로직 -> DB 안에 저장되어있는 정보인지 확인,
    ex) 아이디 정보가 없는 회원입니다. password가 일치하지 않습니다.
     */
    public ResponseEntity<?> login(@Valid UserLogin userLogin
            , HttpServletResponse response) {
        TokenInfo tokenInfo = userService.getLogin(userLogin.getEmail(), userLogin.getPassword());
        addTokenToCookies(response, tokenInfo);
        return ResponseEntity.ok().build();
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
