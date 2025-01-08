package org.example;

public class MissingOTPException extends Exception {
    public MissingOTPException(String message) {
        super(message);
    }
}