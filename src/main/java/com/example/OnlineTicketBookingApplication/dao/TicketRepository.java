package com.example.OnlineTicketBookingApplication.dao;

import com.example.OnlineTicketBookingApplication.model.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Integer> {

    public Ticket findById(int id);
}
