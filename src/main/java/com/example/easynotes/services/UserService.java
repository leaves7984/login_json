package com.example.easynotes.services;

import com.example.easynotes.model.User;

import java.util.List;

public interface UserService {


    public User findUserByEmail(String email);

    public void saveUser(User user);

}
