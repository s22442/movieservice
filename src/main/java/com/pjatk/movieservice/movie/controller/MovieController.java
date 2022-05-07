package com.pjatk.movieservice.movie.controller;

import com.pjatk.movieservice.movie.model.Movie;
import com.pjatk.movieservice.movie.model.MovieCategory;
import com.pjatk.movieservice.movie.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class MovieController {

    public MovieService movieService;

    MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getMovies() {
        return ResponseEntity.ok(this.movieService.getMovies());
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.movieService.getMovieById(id));
    }

    @PostMapping("/movies")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok(this.movieService.addMovie(movie));
    }


    @PostMapping("/movies/{id}")
    public ResponseEntity<Movie> editMovieById(@PathVariable Integer id, @RequestBody Movie movie) {
        return ResponseEntity.ok(this.movieService.editMovieById(id, movie));
    }
}
