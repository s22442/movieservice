package com.pjatk.movieservice.movie.model;


public class Movie {
    private Integer id;
    private String name;
    private MovieCategory movieCategory;


    public Movie() {
    }

    public Movie(String name, MovieCategory movieCategory) {
        this.name = name;
        this.movieCategory = movieCategory;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MovieCategory getMovieCategory() {
        return movieCategory;
    }

    public void setMovieCategory(MovieCategory movieCategory) {
        this.movieCategory = movieCategory;
    }
}
