package com.example.easynotes.controller;

import com.example.easynotes.model.SleepTips;
import com.example.easynotes.repository.SleepTipsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class SleepTipsController {

    @Autowired
    SleepTipsRepository sleepTipsRepository;

    @GetMapping("/tips")
    public List<SleepTips> getTips(){

        return sleepTipsRepository.findAll();
    }

    @RequestMapping(value = "/tips/create", method = RequestMethod.POST)
    @ResponseBody
    public String create(String title, String description, String image) {

        try{
            SleepTips sleepTips = new SleepTips(title,description, image);
            sleepTipsRepository.save(sleepTips);

        }catch (Exception ex) {
            return ex.toString();
        }
        return "success";

    }

}
