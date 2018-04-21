package com.example.easynotes.services;

import com.example.easynotes.model.Calendar;
import com.example.easynotes.repository.UserRepository;
import com.example.easynotes.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;




    @Override
    public User findUserByEmail(String email) {
        return null;
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }


    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @Override
    public Calendar findBydate(User user, String date) {
        for(Calendar calendar:user.getCalendar()){
            if(calendar.getDate().equals(date))
                return calendar;
        }
        return null;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
