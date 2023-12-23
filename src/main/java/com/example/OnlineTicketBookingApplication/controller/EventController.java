package com.example.OnlineTicketBookingApplication.controller;

import com.example.OnlineTicketBookingApplication.model.Event;
import com.example.OnlineTicketBookingApplication.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EventController {

    @Autowired
    private EventService eventService;

    // Get all movies
    @RequestMapping(value = "/event", method = RequestMethod.GET)
    public ResponseEntity<List<Event>> getEvents(){

        try{
            List<Event> list = this.eventService.getAllEventsService();

            return ResponseEntity.of(Optional.of(list));
        }
        catch (Exception e)
        {
            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping(value = "/event/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable int id)
    {
        try{
            Event event = this.eventService.getEventByIdService(id);

            return ResponseEntity.of(Optional.of(event));
        }
        catch (Exception e){
            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping(value = "/event")
    public ResponseEntity<Event> addEvent(@RequestBody Event event){
        try{
            Event e = this.eventService.addEventService(event);

            return ResponseEntity.ok().body(e);
        }
        catch (Exception e){

            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping(value = "/event/update/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable int id, @RequestBody Event event){

        try{
            Event e = this.eventService.updateEventService(id, event);

            return ResponseEntity.of(Optional.of(e));
        }
        catch (Exception e){

            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/event/delete")
    public ResponseEntity<Void> deleteAllEvents()
    {
        try{
            this.eventService.deleteAllEventService();

            return ResponseEntity.ok().build();
        }
        catch (Exception e){

            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/event/delete/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable int id)
    {
        try{
            this.eventService.deleteEventService(id);

            return ResponseEntity.ok().build();
        }
        catch (Exception e){

            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
