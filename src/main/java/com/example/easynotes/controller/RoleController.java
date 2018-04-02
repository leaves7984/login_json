package com.example.easynotes.controller;

import com.example.easynotes.model.Role;
import com.example.easynotes.model.User;
import com.example.easynotes.repository.RoleRepository;
import com.example.easynotes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController
//@RequestMapping("/api")
public class RoleController {

//    @Autowired
//    RoleRepository roleRepository;
//
//    @Autowired
//    UserRepository userRepository;
//
//    @GetMapping("/roles")
//    public List<Role> getAllUsers() {
//        return roleRepository.findAll();
//    }

//    @RequestMapping("/roles/create")
//    @ResponseBody
//    public String create(long id,String rName){
//        String userId = "";
//        try {
//            Role role = new Role(rName);
//            User user = userRepository.getOne(id);
//            user.getRoles().add(role);
//            userId = String.valueOf(user.getId());
//            roleRepository.save(role);
//            userRepository.save(user);
//
//        }
//        catch (Exception ex) {
//            return "Error creating the user: " + ex.toString();
//        }
//        return "User succesfully created with id = " + userId;
//    }
}
