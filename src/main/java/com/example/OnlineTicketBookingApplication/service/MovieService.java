package com.example.OnlineTicketBookingApplication.service;

import com.example.OnlineTicketBookingApplication.dao.MovieRepository;
import com.example.OnlineTicketBookingApplication.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies(){

        List<Movie> movieList = (List<Movie>) this.movieRepository.findAll();

        return movieList;
    }

    public Movie addMovie(Movie movie) {

        Movie m = this.movieRepository.save(movie);

        return m;
    }
}
