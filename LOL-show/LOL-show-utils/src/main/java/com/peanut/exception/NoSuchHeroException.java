package com.peanut.exception;

public class NoSuchHeroException extends RuntimeException {
    public NoSuchHeroException(String message) {
        super(message);
    }
}
