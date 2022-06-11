package com.pjatk.movieservice.movie.controller;

import com.pjatk.movieservice.movie.model.Movie;
import com.pjatk.movieservice.movie.service.MovieService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
    @ApiOperation(value = "Find all movies", notes = "Retrieving movies", response = Movie[].class)
    @ApiResponses({
        @ApiResponse(code = 200, message = "Success", response = Movie[].class)
    })
    public ResponseEntity<List<Movie>> getMovies() {
        return ResponseEntity.ok(movieService.getMovies());
    }


    @GetMapping("/movies/{id}")
    @ApiOperation(value = "Find movie by id", notes = "Retrieving movie by id", response = Movie.class)
    @ApiResponses({
        @ApiResponse(code = 200, message = "Success", response = Movie.class),
        @ApiResponse(code = 404, message = "Not Found")
    })
    public ResponseEntity<Movie> getMovieById(@PathVariable Integer id) {
        return ResponseEntity.ok(movieService.getMovieById(id));
    }

    @PutMapping("/movies/{id}/available")
    @ApiOperation(value = "Make movie available by id", notes = "Making movie available by id and retrieving it", response = Movie.class)
    @ApiResponses({
        @ApiResponse(code = 200, message = "Success", response = Movie.class),
        @ApiResponse(code = 404, message = "Not Found")
    })
    public ResponseEntity<Movie> makeMovieAvailableById(@PathVariable Integer id) {
        return ResponseEntity.ok(movieService.makeMovieAvailableById(id));
    }

    @PutMapping("/movies/{id}/unavailable")
    @ApiOperation(value = "Make movie unavailable by id", notes = "Making movie unavailable by id and retrieving it", response = Movie.class)
    @ApiResponses({
        @ApiResponse(code = 200, message = "Success", response = Movie.class),
        @ApiResponse(code = 404, message = "Not Found")
    })
    public ResponseEntity<Movie> makeMovieUnavailableById(@PathVariable Integer id) {
        return ResponseEntity.ok(movieService.makeMovieUnavailableById(id));
    }

    @PostMapping("/movies")
    @ApiOperation(value = "Add a new movie", notes = "Adding a new movie of the given name and category", response = Movie.class)
    @ApiResponses({
        @ApiResponse(code = 200, message = "Success", response = Movie.class),
        @ApiResponse(code = 400, message = "Bad Request")
    })
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.saveMovie(movie));
    }

    @PostMapping("/movies/{id}")
    @ApiOperation(value = "Edit a movie by id", notes = "Editing a movie of the given name and category", response = Movie.class)
    @ApiResponses({
        @ApiResponse(code = 200, message = "Success", response = Movie.class),
        @ApiResponse(code = 400, message = "Bad Request"),
        @ApiResponse(code = 404, message = "Not Found")
    })
    public ResponseEntity<Movie> editMovieById(@PathVariable Integer id, @RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.editMovieById(id, movie));
    }
}
