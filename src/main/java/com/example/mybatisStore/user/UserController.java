package com.example.mybatisStore.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/home")
    public String getHome(){
        return "There is Home";
    }

    @GetMapping("/signup")
    public String getSignup() {
        return "There is signup";
    }
}
