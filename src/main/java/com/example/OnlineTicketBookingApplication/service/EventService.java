package com.example.OnlineTicketBookingApplication.service;

import com.example.OnlineTicketBookingApplication.dao.EventRepository;
import com.example.OnlineTicketBookingApplication.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEventsService() {

        List<Event> eventList = (List<Event>) this.eventRepository.findAll();

        return eventList;
    }

    public Event getEventByIdService(int id) {

        return this.eventRepository.findById(id);
    }

    public Event addEventService(Event event) {

        Event e = this.eventRepository.save(event);

        return e;
    }

    public Event updateEventService(int id, Event event) {

        event.setId(id);

        Event e = this.eventRepository.save(event);

        return e;
    }

    public void deleteEventService(int id) {

        this.eventRepository.deleteById(id);
    }

    public void deleteAllEventService() {
        this.eventRepository.deleteAll();
    }
}
