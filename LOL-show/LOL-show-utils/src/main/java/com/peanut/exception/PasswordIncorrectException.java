package com.peanut.exception;

/**
 * @author Peanut
 */
public class PasswordIncorrectException extends RuntimeException {
    public PasswordIncorrectException(String message) {
        super(message);
    }
    public PasswordIncorrectException(){}
}
