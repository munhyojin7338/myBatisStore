package com.example.mybatisStore.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserMapper userMapper;


    @Override
    public Optional<User> findByEmail(String userEmail) {
        return userMapper.findByEmail(userEmail);
    }
}
