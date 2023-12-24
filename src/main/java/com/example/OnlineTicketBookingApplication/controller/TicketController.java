package com.example.OnlineTicketBookingApplication.controller;

import com.example.OnlineTicketBookingApplication.model.Ticket;
import com.example.OnlineTicketBookingApplication.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TicketController {

    @Autowired
    private TicketService ticketService;

    // Get all movies
    @RequestMapping(value = "/ticket", method = RequestMethod.GET)
    public ResponseEntity<List<Ticket>> getTickets(){

        try{
            List<Ticket> list = this.ticketService.getAllTicketsService();

            return ResponseEntity.of(Optional.of(list));
        }
        catch (Exception e)
        {
            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping(value = "/ticket/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable int id)
    {
        try{
            Ticket ticket = this.ticketService.getTicketByIdService(id);

            return ResponseEntity.of(Optional.of(ticket));
        }
        catch (Exception e){
            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping(value = "/ticket")
    public ResponseEntity<Ticket> addTicket(@RequestBody Ticket ticket){
        try{
            Ticket t = this.ticketService.addTicketService(ticket);

            return ResponseEntity.ok().body(t);
        }
        catch (Exception e){

            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping(value = "/ticket/update/{id}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable int id, @RequestBody Ticket ticket){

        try{
            Ticket t = this.ticketService.updateTicketService(id, ticket);

            return ResponseEntity.of(Optional.of(t));
        }
        catch (Exception e){

            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/ticket/delete")
    public ResponseEntity<Void> deleteAllTicket()
    {
        try{
            this.ticketService.deleteAllTicketService();

            return ResponseEntity.ok().build();
        }
        catch (Exception e){

            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/ticket/delete/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable int id)
    {
        try{
            this.ticketService.deleteTicketService(id);

            return ResponseEntity.ok().build();
        }
        catch (Exception e){

            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
