package com.example.easynotes.webController;

import com.example.easynotes.model.SleepTips;
import com.example.easynotes.model.Tip;
import com.example.easynotes.repository.SleepTipsRepository;
import com.example.easynotes.repository.TipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("web")
public class WebTipController {

    @Autowired
    TipRepository tipRepository;

    @Autowired
    SleepTipsRepository sleepTipsRepository;


    @GetMapping("/tips/create")
    public String TipForm(Model model) {
        List<SleepTips> sleepTips = sleepTipsRepository.findAll();
        Tip tip = new Tip();
        String selected = "";
        model.addAttribute("tip", tip);
        model.addAttribute("sleepTips",sleepTips);
        return "tip";
    }
    @PostMapping("/tips/create")
    public String SleepTipsSubmit(@ModelAttribute("tip") Tip tip, HttpServletRequest request) {

        String selectedTitle= request.getParameter("selectedTitle");
        System.out.println(selectedTitle);
        tipRepository.save(tip);
        System.out.println(tip);
        try{
            SleepTips sleepTips = sleepTipsRepository.findByTitle(selectedTitle);
            sleepTips.getTips().add(tip);
            System.out.println(sleepTips);
            sleepTipsRepository.save(sleepTips);

        }catch (Exception ex) {
            return ex.toString();
        }
        return "tip";
    }

}
