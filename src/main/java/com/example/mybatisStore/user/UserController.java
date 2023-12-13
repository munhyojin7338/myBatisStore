package com.example.mybatisStore.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@Valid UserSignup userSignup) {
        System.out.println("4");
        Long userId = userService.getSignup(userSignup);
        System.out.println(userId);
        return ResponseEntity.ok(userId);
    }
}
