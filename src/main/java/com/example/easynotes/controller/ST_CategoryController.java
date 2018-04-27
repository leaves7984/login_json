package com.example.easynotes.controller;

import com.example.easynotes.model.ST_Category;
import com.example.easynotes.repository.ST_CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/api")
public class ST_CategoryController{

    @Autowired
    ST_CategoryRepository st_categoryRepository;

    @GetMapping("/stCategory")
    public List<ST_Category> getCategory(){

        return st_categoryRepository.findAll();
    }
    @GetMapping("/stByTitle")
    public ST_Category getByTitle(String title){

        return st_categoryRepository.findByTitle(title);
    }

}