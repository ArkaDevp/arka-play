package com.arka.play.domain.exception;

public class MovieAlreadyExistsException extends RuntimeException {
    public MovieAlreadyExistsException(String message) {

        super("The movie" + message + " already exists.");
    }
}
