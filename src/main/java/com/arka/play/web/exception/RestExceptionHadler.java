package com.arka.play.web.exception;

import com.arka.play.domain.exception.MovieAlreadyExistsException;
import com.arka.play.domain.exception.MovieNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHadler {
    @ExceptionHandler(MovieAlreadyExistsException.class)
    public ResponseEntity<Error> handleException(MovieAlreadyExistsException exception){
        Error error = new Error("movie-already-exists", exception.getMessage());

        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<Error> movieNotFoundHandleException(MovieNotFoundException exception){
        Error error = new Error("movie-not-found", exception.getMessage());

        return ResponseEntity.badRequest().body(error);
    }
}
