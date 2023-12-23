package com.example.OnlineTicketBookingApplication.controller;

import com.example.OnlineTicketBookingApplication.model.User;
import com.example.OnlineTicketBookingApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    // Get all movies
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUsers(){

        try{
            List<User> list = this.userService.getAllUsersService();

            return ResponseEntity.of(Optional.of(list));
        }
        catch (Exception e)
        {
            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping(value = "/user/{username}")
    public ResponseEntity<User> getUserById(@PathVariable String username)
    {
        try{
            User user = this.userService.getUserByIdService(username);

            return ResponseEntity.of(Optional.of(user));
        }
        catch (Exception e){
            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping(value = "/user")
    public ResponseEntity<User> addUser(@RequestBody User user){
        try{
            User u = this.userService.addUserService(user);

            return ResponseEntity.ok().body(u);
        }
        catch (Exception e){

            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping(value = "/user/update/{username}")
    public ResponseEntity<User> updateUser(@PathVariable String username, @RequestBody User user){

        try{
            User u = this.userService.updateUserService(username, user);

            return ResponseEntity.of(Optional.of(u));
        }
        catch (Exception e){

            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/user/delete")
    public ResponseEntity<Void> deleteAllUser()
    {
        try{
            this.userService.deleteAllUserService();

            return ResponseEntity.ok().build();
        }
        catch (Exception e){

            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/user/delete/{username}")
    public ResponseEntity<Void> deleteUser(@PathVariable String username)
    {
        try{
            this.userService.deleteUserService(username);

            return ResponseEntity.ok().build();
        }
        catch (Exception e){

            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
