package com.example.OnlineTicketBookingApplication.dao;

import com.example.OnlineTicketBookingApplication.model.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Integer> {
}
