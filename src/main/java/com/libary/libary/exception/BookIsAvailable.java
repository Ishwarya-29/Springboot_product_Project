package com.libary.libary.exception;

public class BookIsAvailable extends RuntimeException{
    public BookIsAvailable(String message)
    {
        super(message);
    }
}
