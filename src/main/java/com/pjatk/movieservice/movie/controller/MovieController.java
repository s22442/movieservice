package com.pjatk.movieservice.movie.controller;

import com.pjatk.movieservice.movie.model.Movie;
import com.pjatk.movieservice.movie.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MovieController {

    public MovieService movieService;

    MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getMovies() {
        return ResponseEntity.ok(movieService.getMovies());
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Integer id) {
        return ResponseEntity.ok(movieService.getMovieById(id));
    }

    @PatchMapping("/movies/{id}/available")
    public ResponseEntity<Movie> makeMovieAvailableById(@PathVariable Integer id) {
        return ResponseEntity.ok(movieService.makeMovieAvailableById(id));
    }

    @PostMapping("/movies")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.saveMovie(movie));
    }

    @PostMapping("/movies/{id}")
    public ResponseEntity<Movie> editMovieById(@PathVariable Integer id, @RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.editMovieById(id, movie));
    }
}
