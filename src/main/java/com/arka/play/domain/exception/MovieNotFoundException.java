package com.arka.play.domain.exception;

public class MovieNotFoundException extends RuntimeException {
    public MovieNotFoundException(String message) {
        super("The movie with id: " + message + " does not exist.");
    }
}
