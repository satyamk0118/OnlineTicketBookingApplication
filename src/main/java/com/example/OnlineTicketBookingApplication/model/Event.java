package com.example.OnlineTicketBookingApplication.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "theater_id")
    private Theater theater;

    @OneToOne(mappedBy = "event")
    private Ticket ticket;

    private LocalDate time;

    public Event(int id, Movie movie, Theater theater, LocalDate time) {
        this.id = id;
        this.movie = movie;
        this.theater = theater;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }
}
