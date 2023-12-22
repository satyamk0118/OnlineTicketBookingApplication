package com.example.OnlineTicketBookingApplication.controller;

import com.example.OnlineTicketBookingApplication.model.Movie;
import com.example.OnlineTicketBookingApplication.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    public List<Movie> getMovies(){

        return this.movieService.getAllMovies();
    }

    @PostMapping(value = "/movie")
    public Movie addMovie(@RequestBody Movie movie){
        return this.movieService.addMovie(movie);
    }
}
