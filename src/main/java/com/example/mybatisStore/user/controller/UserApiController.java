package com.example.mybatisStore.user.controller;


import com.example.mybatisStore.user.entity.User;
import com.example.mybatisStore.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserApiController {
    private final UserService userService;

    @GetMapping("/user/{id}")
    public User findUser(@PathVariable Long id){
        return userService.getUserById(id);
    }
}
