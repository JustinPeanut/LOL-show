package com.peanut.exception;

/**
 * @author Peanut
 */
public class NoSuchMemberException extends RuntimeException {

    public NoSuchMemberException(String message) {
        super(message);
    }
    public NoSuchMemberException(){}
}
