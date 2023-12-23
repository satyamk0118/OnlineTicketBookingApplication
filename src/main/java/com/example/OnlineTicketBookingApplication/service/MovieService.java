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

    public List<Movie> getAllMoviesService(){

        List<Movie> movieList = (List<Movie>) this.movieRepository.findAll();

        return movieList;
    }

    public Movie addMovieService(Movie movie) {

        Movie m = this.movieRepository.save(movie);

        return m;
    }

    public Movie getMovieByIdService(int id) {

        Movie m = null;
        m = this.movieRepository.findById(id);

        return m;
    }

    public Movie updateMovieService(int id, Movie m){

        Movie movie = null;

        m.setId(id);

        movie = this.movieRepository.save(m);

        return movie;
    }

    public void deleteAllMovieService() {

        this.movieRepository.deleteAll();
    }

    public void deleteMovieService(int id) {

        this.movieRepository.deleteById(id);
    }
}
