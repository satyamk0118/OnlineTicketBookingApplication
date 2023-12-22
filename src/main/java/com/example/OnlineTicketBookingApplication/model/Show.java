package com.example.OnlineTicketBookingApplication.model;

import java.time.LocalDate;

public class Show {

    private int id;

    private Movie movie;

    private Theater theater;

    private LocalDate time;

    public Show(int id, Movie movie, Theater theater, LocalDate time) {
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
