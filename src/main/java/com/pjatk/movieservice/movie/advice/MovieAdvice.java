package com.pjatk.movieservice.movie.advice;

import com.pjatk.movieservice.movie.exception.IncorrectMovieException;
import com.pjatk.movieservice.movie.exception.MovieNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MovieAdvice {

    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<String> handleMovieNotFoundException(MovieNotFoundException e) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(IncorrectMovieException.class)
    public ResponseEntity<String> handleIncorrectMovieException(MovieNotFoundException e) {
        return ResponseEntity.badRequest().build();
    }
}
