package com.peanut.exception;

public class UserNameAlreadyUsedException extends RuntimeException{
    public UserNameAlreadyUsedException(String message) {
        super(message);
    }
}
