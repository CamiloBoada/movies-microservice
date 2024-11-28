package com.challenge.movies.exception;

public class NotFoundMoviesException extends RuntimeException {
    public NotFoundMoviesException(String message) {
        super(message);
    }
}