package com.example.tema_10.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class TokenRefreshException extends RuntimeException{
    @Serial
    private static final long serialVersionnUID = 1L;
    public TokenRefreshException(String token, String message){
        super(String.format("Failed for [%s]: %s", token, message));
    }
}