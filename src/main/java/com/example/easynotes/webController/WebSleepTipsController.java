package com.example.easynotes.webController;
import com.example.easynotes.model.ST_Category;
import com.example.easynotes.model.SleepTips;
import com.example.easynotes.repository.ST_CategoryRepository;
import com.example.easynotes.repository.SleepTipsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping("/web")
public class WebSleepTipsController {


    @Autowired
    SleepTipsRepository sleepTipsRepository;

    @Autowired
    ST_CategoryRepository st_categoryRepository;

    @RequestMapping("/sleepTips")
    public String SleepTips(Model model){

        List<SleepTips> sleepTips = sleepTipsRepository.findAll();
        model.addAttribute("sleepTips",sleepTips);
        return "sleepTips_demo";
    }

    @GetMapping("/sleepTips/create")
    public String SleepTipsForm(Model model) {
        List<ST_Category> st_categories = st_categoryRepository.findAll();
        SleepTips sleepTips = new SleepTips();
        model.addAttribute("st_categories", st_categories);
        model.addAttribute("sleepTips", sleepTips);
        return "sleepTips";
    }

    @PostMapping("/sleepTips/create")
    public String SleepTipsSubmit(@ModelAttribute SleepTips sleepTips, HttpServletRequest request) {
        String selectedTitle= request.getParameter("selectedTitle");
        System.out.println(selectedTitle);
        sleepTipsRepository.save(sleepTips);
        try{
            ST_Category st_category =st_categoryRepository.findByTitle(selectedTitle);
            st_category.getSleepTips().add(sleepTips);
            st_categoryRepository.save(st_category);

        }catch (Exception ex){
            return ex.toString();
        }
        System.out.println(sleepTips);
        return "sleepTips_demo";


    }


}

