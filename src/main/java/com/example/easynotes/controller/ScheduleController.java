package com.example.easynotes.controller;


import com.example.easynotes.model.Calendar;
import com.example.easynotes.model.Schedule;
import com.example.easynotes.repository.CalendarRepository;
import com.example.easynotes.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ScheduleController {

    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    CalendarRepository calendarRepository;

    @GetMapping("/schedules")
    public List<Schedule> getAllSchedule() {
        return scheduleRepository.findAll();
    }

    
}
