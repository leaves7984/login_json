package com.example.easynotes.services;

import com.example.easynotes.model.Calendar;
import com.example.easynotes.model.User;

import java.util.Date;
import java.util.List;

public interface UserService {


    public User findUserByEmail(String email);

    public void saveUser(User user);
    public User findByUsername(String username);
    public Calendar findBydate(User user, String date);

}
