package com.example.easynotes.controller;


import com.example.easynotes.model.Calendar;
import com.example.easynotes.model.Schedule;
import com.example.easynotes.model.User;
import com.example.easynotes.repository.CalendarRepository;
import com.example.easynotes.repository.ScheduleRepository;
import com.example.easynotes.repository.UserRepository;
import com.example.easynotes.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = {"http://localhost:8100","http://localhost:8080","file://*"})
@CrossOrigin
@RestController
@RequestMapping("/api")
public class ScheduleController {

    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    CalendarRepository calendarRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/schedules")
    public List<Schedule> getAllSchedule() {
        return scheduleRepository.findAll();
    }


    @RequestMapping(value="/schedules/create",method=RequestMethod.POST)
    @ResponseBody
    public Boolean create(String username,
                          String date,
                          Integer time,
                          String sports,
                          String description,
                          String from,
                          String to){

        User user = userRepository.findByUsername(username);
        System.out.println(username+"  "+date+"  "+time+"  "+from+"  "+to);
        if(user == null)
            return false;
        try {
            Calendar calendar = userService.findBydate(user,date);

            System.out.println(username + date + time + sports + description);

            Schedule schedule= new Schedule(from,to,time,sports,description);
            if(calendar != null){
                calendar.getSchedule().add(schedule);
            }else{
                calendar = new Calendar(date);
                user.getCalendar().add(calendar);
                calendar.getSchedule().add(schedule);
            }

            scheduleRepository.save(schedule);
            calendarRepository.save(calendar);
            userRepository.save(user);

        }
        catch (Exception ex) {
            return false;
        }
        return true;
    }
    @RequestMapping(value="/schedules/delete",method=RequestMethod.POST)
    @ResponseBody
    public Boolean delete(String username,Long calendarId,Long scheduleId){

        System.out.println(username);
        System.out.println(calendarId);
        System.out.println(scheduleId);
        User user = userRepository.findByUsername(username);
        try {
            Calendar calendar = calendarRepository.getOne(calendarId);

            System.out.println(calendar);
            if(calendar.getSchedule().isEmpty()){
                user.getCalendar().remove(calendar);
                calendarRepository.delete(calendar);
                userRepository.save(user);
            }else{
                Schedule schedule = scheduleRepository.getOne(scheduleId);
                calendar.getSchedule().remove(schedule);
                scheduleRepository.delete(schedule);
                calendarRepository.save(calendar);
            }
        }
        catch (Exception ex) {

            return false;
        }
        return true;
    }
}
