package com.jeyhung.graphql.exception;

public class DataNotFoundException extends RuntimeException {
    public DataNotFoundException(String message) {
        super(message);
    }

    public static void handle(String message) {
        throw new DataNotFoundException(message);
    }
}
