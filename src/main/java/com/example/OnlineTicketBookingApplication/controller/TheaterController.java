package com.example.OnlineTicketBookingApplication.controller;

import com.example.OnlineTicketBookingApplication.model.Theater;
import com.example.OnlineTicketBookingApplication.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TheaterController {

    @Autowired
    private TheaterService theaterService;

    // Get all movies
    @RequestMapping(value = "/theater", method = RequestMethod.GET)
    public ResponseEntity<List<Theater>> getTheaters(){

        try{
            List<Theater> list = this.theaterService.getAllTheatersService();

            return ResponseEntity.of(Optional.of(list));
        }
        catch (Exception e)
        {
            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping(value = "/theater/{id}")
    public ResponseEntity<Theater> getTheaterById(@PathVariable int id)
    {
        try{
            Theater theater = this.theaterService.getTheaterByIdService(id);

            return ResponseEntity.of(Optional.of(theater));
        }
        catch (Exception e){
            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping(value = "/theater")
    public ResponseEntity<Theater> addTheater(@RequestBody Theater theater){
        try{
            Theater t = this.theaterService.addTheaterService(theater);

            return ResponseEntity.ok().body(t);
        }
        catch (Exception e){

            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping(value = "/theater/update/{id}")
    public ResponseEntity<Theater> updateTheater(@PathVariable int id, @RequestBody Theater theater){

        try{
            Theater t = this.theaterService.updateTheaterService(id, theater);

            return ResponseEntity.of(Optional.of(t));
        }
        catch (Exception e){

            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/theater/delete")
    public ResponseEntity<Void> deleteAllTheater()
    {
        try{
            this.theaterService.deleteAllTheaterService();

            return ResponseEntity.ok().build();
        }
        catch (Exception e){

            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/theater/delete/{id}")
    public ResponseEntity<Void> deleteTheater(@PathVariable int id)
    {
        try{
            this.theaterService.deleteTheaterService(id);

            return ResponseEntity.ok().build();
        }
        catch (Exception e){

            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
