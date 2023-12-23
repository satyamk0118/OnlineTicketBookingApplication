package com.example.OnlineTicketBookingApplication.dao;

import com.example.OnlineTicketBookingApplication.model.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Integer> {
}
