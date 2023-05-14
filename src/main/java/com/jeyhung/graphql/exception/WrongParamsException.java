package com.jeyhung.graphql.exception;

public class WrongParamsException extends RuntimeException {
    public WrongParamsException(String message) {
        super(message);
    }

    public static void handle(String message) {
        throw new WrongParamsException(message);
    }
}