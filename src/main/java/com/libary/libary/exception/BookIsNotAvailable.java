package com.libary.libary.exception;

public class BookIsNotAvailable extends RuntimeException{
    public BookIsNotAvailable(String message)
    {
        super(message);
    }
}
