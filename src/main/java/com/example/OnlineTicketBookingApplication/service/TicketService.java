package com.example.OnlineTicketBookingApplication.service;

import com.example.OnlineTicketBookingApplication.dao.MovieRepository;
import com.example.OnlineTicketBookingApplication.dao.TicketRepository;
import com.example.OnlineTicketBookingApplication.model.Movie;
import com.example.OnlineTicketBookingApplication.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public List<Ticket> getAllTicketsService(){

        List<Ticket> ticketList = (List<Ticket>) this.ticketRepository.findAll();

        return ticketList;
    }

    public Ticket addTicketService(Ticket ticket) {

        Ticket t = this.ticketRepository.save(ticket);

        return t;
    }

    public Ticket getTicketByIdService(int id) {

        Ticket t = this.ticketRepository.findById(id);

        return t;
    }

    public Ticket updateTicketService(int id, Ticket ticket){

        ticket.setId(id);

        Ticket t = this.ticketRepository.save(ticket);

        return t;
    }

    public void deleteAllTicketService() {

        this.ticketRepository.deleteAll();
    }

    public void deleteTicketService(int id) {

        this.ticketRepository.deleteById(id);
    }
}
