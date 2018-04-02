package com.example.easynotes.controller;

import com.example.easynotes.model.Calendar;
import com.example.easynotes.model.User;
import com.example.easynotes.repository.CalendarRepository;
import com.example.easynotes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CalendarController {

    @Autowired
    CalendarRepository calendarRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/calendars")
    public List<Calendar> getAllCalendar() {
        return calendarRepository.findAll();
    }

    @RequestMapping("/calendars/create")
    @ResponseBody
    public String create(long id,String date){
        String userId = "";
        try {
            Calendar calendar = new Calendar(date);
            User user = userRepository.getOne(id);
            user.getCalendar().add(calendar);
            userId = String.valueOf(user.getId());
            calendarRepository.save(calendar);
            userRepository.save(user);

        }
        catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }
        return "User succesfully created with id = " + userId;
    }

}
