package com.example.OnlineTicketBookingApplication.model;

import jakarta.persistence.*;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username")
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "event_id")
    private Event event;

    private int seatno;

    public Ticket() {
    }

    public Ticket(int id, User user, Event event, int seatno) {
        this.id = id;
        this.user = user;
        this.event = event;
        this.seatno = seatno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public int getSeatno() {
        return seatno;
    }

    public void setSeatno(int seatno) {
        this.seatno = seatno;
    }
}
