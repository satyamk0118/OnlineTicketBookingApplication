package com.example.OnlineTicketBookingApplication.dao;

import com.example.OnlineTicketBookingApplication.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,String> {

    public User findByUsername(String username);
}
