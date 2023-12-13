package com.example.mybatisStore.user;

import com.example.mybatisStore.user.jwt.TokenInfo;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup") // 회원가입
    public ResponseEntity<?> signup(@Valid UserSignup userSignup) {
        Long userId = userService.getSignup(userSignup);
        return ResponseEntity.ok(userId);
    }

    @PostMapping("/login")
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
