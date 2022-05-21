package com.pjatk.movieservice.movie.repository;

import com.pjatk.movieservice.movie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    List<Movie> findAll();
    Optional<Movie> findById(Integer id);
    Movie save(Movie movie);
}
