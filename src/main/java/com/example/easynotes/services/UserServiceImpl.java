package com.example.easynotes.services;

import com.example.easynotes.model.Role;
import com.example.easynotes.repository.RoleRepository;
import com.example.easynotes.repository.UserRepository;
import com.example.easynotes.model.User;
import com.example.easynotes.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    private RoleRepository roleRepository;




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
}
