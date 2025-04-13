package com.libary.libary.exception;

public class UserNotFound extends RuntimeException{
    public UserNotFound(String message)
    {
        super(message);
    }
}
