package com.libary.libary.exception;

public class UserExist extends RuntimeException{
    public UserExist(String message)
    {
        super(message);
    }
}
