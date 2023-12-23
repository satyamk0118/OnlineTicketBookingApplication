package com.example.OnlineTicketBookingApplication.controller;

import com.example.OnlineTicketBookingApplication.model.Movie;
import com.example.OnlineTicketBookingApplication.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    // Get all movies
    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    public ResponseEntity<List<Movie>> getMovies(){

        try{
            List<Movie> list = this.movieService.getAllMoviesService();

            return ResponseEntity.of(Optional.of(list));
        }
        catch (Exception e)
        {
            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping(value = "/movie/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable int id)
    {
       try{
           Movie movie = this.movieService.getMovieByIdService(id);

           return ResponseEntity.of(Optional.of(movie));
       }
       catch (Exception e){
           e.printStackTrace();

           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }
    }

    @PostMapping(value = "/movie")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie){
        try{
            Movie m = this.movieService.addMovieService(movie);

            return ResponseEntity.ok().body(movie);
        }
        catch (Exception e){

            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping(value = "/movie/update/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable int id, @RequestBody Movie m){

        try{
            Movie movie = this.movieService.updateMovieService(id, m);

            return ResponseEntity.of(Optional.of(movie));
        }
        catch (Exception e){

            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/movie/delete")
    public ResponseEntity<Void> deleteAllMovie()
    {
        try{
            this.movieService.deleteAllMovieService();

            return ResponseEntity.ok().build();
        }
        catch (Exception e){

            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/movie/delete/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable int id)
    {
        try{
            this.movieService.deleteMovieService(id);

            return ResponseEntity.ok().build();
        }
        catch (Exception e){

            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
