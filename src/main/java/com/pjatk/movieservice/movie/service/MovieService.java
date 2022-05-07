package com.pjatk.movieservice.movie.service;

import com.pjatk.movieservice.movie.exception.IncorrectMovieException;
import com.pjatk.movieservice.movie.exception.MovieNotFoundException;
import com.pjatk.movieservice.movie.model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private List<Movie> movies;

    MovieService() {
        this.movies = List.of(new Movie());
    }

    public List<Movie> getMovies() {
        return this.movies;
    }

    public Movie getMovieById(Integer id) {
        return this.getMovies().stream()
                .filter(movie -> movie.getId().equals(id))
                .findFirst()
                .orElseThrow(MovieNotFoundException::new);
    }

    public Movie addMovie(Movie movie) {
        this.movies.add(movie);
        return movie;
    }

    public Movie editMovieById(Integer id, Movie movie) {
        movie.setId(id);
        this.addMovie(movie);
        return movie;
    }
}
