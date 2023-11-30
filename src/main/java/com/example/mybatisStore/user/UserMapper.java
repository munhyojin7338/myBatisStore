package com.example.mybatisStore.user;

import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface UserMapper {
    Optional<User> findByEmail(String userEmail);
}
