package com.example.easynotes.controller;

import com.example.easynotes.model.Sleep;
import com.example.easynotes.repository.SleepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Text;

import java.sql.Blob;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class SleepController {

    @Autowired
    SleepRepository sleepRepository;

    @GetMapping("/safeSleep")
    public List<Sleep> getSleep(){

        return sleepRepository.findAll();
    }

    @RequestMapping(value="/safeSleep/create",method= RequestMethod.POST)
    @ResponseBody
    public String create(String title, String description, String article, String image, String video){

        System.out.println(title+"  "+description);
        try{
            Sleep sleep = new Sleep(title,description,article,image,video);
            sleepRepository.save(sleep);

        }catch (Exception ex) {
            return ex.toString();
        }

        return "success";
    }

    @RequestMapping("/safeSleep/delete")
    @ResponseBody
    public String delete(Long id) {
        try {

            sleepRepository.deleteById(id);
        }
        catch (Exception ex) {
            return "Error deleting the safeSleepObject:" + ex.toString();
        }
        return "User succesfully deleted!";
    }

    @RequestMapping("/safeSleep/getSleep")
    @ResponseBody
    public  Sleep getSleep(Long id){
        System.out.println(id);
        Optional<Sleep> sleep = sleepRepository.findById(id);
        if(sleep.isPresent()){
            return sleep.get();
        }else{
            return null;
        }

    }


}
