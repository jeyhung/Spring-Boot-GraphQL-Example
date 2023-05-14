package com.jeyhung.graphql.exception;

public class DataDuplicatedException extends RuntimeException {
    public DataDuplicatedException(String message) {
        super(message);
    }

    public static void handle(String message) {
        throw new DataDuplicatedException(message);
    }
}
