package com.example.easynotes.controller;

import com.example.easynotes.model.SleepTips;
import com.example.easynotes.model.Tip;
import com.example.easynotes.repository.SleepTipsRepository;
import com.example.easynotes.repository.TipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class TipController {

    @Autowired
    TipRepository tipRepository;

    @Autowired
    SleepTipsRepository sleepTipsRepository;

    @RequestMapping(value = "/tip/create", method = RequestMethod.POST)
    @ResponseBody
    public String create(String topic, String content, String title){

        System.out.println(title);
        System.out.println(topic);
        System.out.println(content);
        Tip tip = new Tip(topic,content);
        try{

            tipRepository.save(tip);
            SleepTips sleepTips = sleepTipsRepository.findByTitle(title);
            sleepTips.getTips().add(tip);
            System.out.println(sleepTips);
            sleepTipsRepository.save(sleepTips);

        }catch (Exception ex) {
            return ex.toString();
        }
        return "success";

    }
}
