package com.example.OnlineTicketBookingApplication.service;

import com.example.OnlineTicketBookingApplication.dao.MovieRepository;
import com.example.OnlineTicketBookingApplication.dao.UserRepository;
import com.example.OnlineTicketBookingApplication.model.Movie;
import com.example.OnlineTicketBookingApplication.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsersService(){

        List<User> userList = (List<User>) this.userRepository.findAll();

        return userList;
    }

    public User addUserService(User user) {

        User u = this.userRepository.save(user);

        return u;
    }

    public User getUserByIdService(String username) {

        User u = null;
        u = this.userRepository.findByUsername(username);

        return u;
    }

    public User updateUserService(String username, User user){

        User u = null;

        user.setUsername(username);

        u = this.userRepository.save(user);

        return u;
    }

    public void deleteAllUserService() {

        this.userRepository.deleteAll();
    }

    public void deleteUserService(String username) {

        this.userRepository.deleteById(username);
    }
}
