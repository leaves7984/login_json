package com.example.easynotes.webController;

import com.example.easynotes.model.Sleep;
import com.example.easynotes.model.SleepTips;
import com.example.easynotes.repository.SleepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/web")
public class WebSleepController {

    @Autowired
    SleepRepository sleepRepository;

    @GetMapping("/safeSleep/create")
    public String safeSleepForm(Model model) {
        Sleep sleep = new Sleep();

        model.addAttribute("sleep", sleep);
        return "sleep";
    }

    @PostMapping("/safeSleep/create")
    public String safeSleepSubmit(@ModelAttribute Sleep sleep) {
        if(sleep.getTitle().equals("")|| sleep.getArticle().equals("")){
            return "sleep";
        }
        sleepRepository.save(sleep);
        System.out.println(sleep);
        return "sleep";
    }

}
