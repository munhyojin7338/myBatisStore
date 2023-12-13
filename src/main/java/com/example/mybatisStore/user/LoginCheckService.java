package com.example.mybatisStore.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginCheckService {
    private final UserMapper userMapper;

    public boolean checkEmail(String email) {
        return userMapper.existsByEmail(email);
    }
}
