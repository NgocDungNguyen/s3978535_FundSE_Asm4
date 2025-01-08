package org.example;

public class ExpiredOTPException extends Exception {
    public ExpiredOTPException(String message) {
        super(message);
    }
}