package com.example.tema_7.exception;

public class UserAlreadyExistException extends Exception{
    public UserAlreadyExistException(){
        super("User already exist with this username");
    }
}
