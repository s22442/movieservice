package com.pjatk.movieservice.movie.service;

import com.pjatk.movieservice.movie.exception.MovieNotFoundException;
import com.pjatk.movieservice.movie.model.Movie;
import com.pjatk.movieservice.movie.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(Integer id) {
        return movieRepository.findById(id).orElseThrow(MovieNotFoundException::new);
    }

    public Movie makeMovieAvailableById(Integer id) {
        Movie movie = getMovieById(id);
        movie.setAvailable(true);
        saveMovie(movie);
        return movie;
    }

    public Movie makeMovieUnavailableById(Integer id) {
        Movie movie = getMovieById(id);
        movie.setAvailable(false);
        saveMovie(movie);
        return movie;
    }

    public Movie saveMovie(Movie movie) {
        movieRepository.save(movie);
        return movie;
    }

    public Movie editMovieById(Integer id, Movie newMovie) {
        Movie movie = getMovieById(id);
        movie.setName(newMovie.getName());
        movie.setCategory(newMovie.getCategory());
        return saveMovie(movie);
    }
}
