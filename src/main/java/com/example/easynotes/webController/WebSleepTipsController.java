package com.example.easynotes.webController;
import com.example.easynotes.model.SleepTips;
import com.example.easynotes.repository.SleepTipsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/web")
public class WebSleepTipsController {


    @Autowired
    SleepTipsRepository sleepTipsRepository;

    @RequestMapping({"/index","/",""})
    public String getIndex(){
        return "index";
    }

    @GetMapping("/sleepTips/create")
    public String SleepTipsForm(Model model) {
        SleepTips sleepTips = new SleepTips();
        System.out.println(sleepTips.getId());
        model.addAttribute("sleepTips", sleepTips);
        return "sleepTips";
    }

    @PostMapping("/sleepTips/create")
    public String SleepTipsSubmit(@ModelAttribute SleepTips sleepTips) {
        sleepTipsRepository.save(sleepTips);
        System.out.println(sleepTips);
        return "sleepTips";
    }


}

