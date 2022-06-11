package com.pjatk.movieservice.movie.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@ApiModel(value = "Movie", description = "A movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "The unique identifier of the given movie")
    private Integer id;

    @ApiModelProperty(value = "The name of the given movie")
    private String name;

    @Enumerated(EnumType.STRING)
    @ApiModelProperty(value = "The category of the given movie")
    private MovieCategory category;

    @ApiModelProperty(value = "The availability of the given movie")
    private boolean isAvailable;

    public Movie() {
    }

    public Movie(String name, MovieCategory category) {
        this.name = name;
        this.category = category;
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

    public MovieCategory getCategory() {
        return category;
    }

    public void setCategory(MovieCategory movieCategory) {
        this.category = movieCategory;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
