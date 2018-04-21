package com.example.easynotes.services;

import com.example.easynotes.model.Calendar;
import com.example.easynotes.repository.CalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalendarServiceImpl implements CalendarService {

    @Autowired
    CalendarRepository calendarRepository;

    @Override
    public Calendar findByDate(String email) {


        return calendarRepository.findByDate(email);
    }
}
