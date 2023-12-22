package com.example.mybatisStore.user.exception;

public class LoginErrorException extends RuntimeException {
    public LoginErrorException(String message) {
        super(message);
    }
}
