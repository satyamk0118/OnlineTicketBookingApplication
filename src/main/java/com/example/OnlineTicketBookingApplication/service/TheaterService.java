package com.example.OnlineTicketBookingApplication.service;

import com.example.OnlineTicketBookingApplication.dao.TheaterRepository;
import com.example.OnlineTicketBookingApplication.model.Theater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TheaterService {

    @Autowired
    private TheaterRepository theaterRepository;

    public List<Theater> getAllTheatersService(){

        List<Theater> theaterList = (List<Theater>) this.theaterRepository.findAll();

        return theaterList;
    }

    public Theater addTheaterService(Theater theater) {

        return this.theaterRepository.save(theater);
    }

    public Theater getTheaterByIdService(int id) {

        Theater t = null;
        t = this.theaterRepository.findById(id);

        return t;
    }

    public Theater updateTheaterService(int id, Theater theater){

        Theater t = null;

        theater.setId(id);

        t = this.theaterRepository.save(theater);

        return t;
    }

    public void deleteAllTheaterService() {

        this.theaterRepository.deleteAll();
    }

    public void deleteTheaterService(int id) {

        this.theaterRepository.deleteById(id);
    }
}
