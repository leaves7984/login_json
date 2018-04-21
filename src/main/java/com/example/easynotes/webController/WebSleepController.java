package com.example.easynotes.webController;

import com.example.easynotes.model.Category;
import com.example.easynotes.model.Sleep;
import com.example.easynotes.model.SleepTips;
import com.example.easynotes.repository.CategoryRepository;
import com.example.easynotes.repository.SleepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/web")
public class WebSleepController {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    SleepRepository sleepRepository;

    @GetMapping("/safeSleep/create")
    public String safeSleepForm(Model model) {
        List<Category> categories = categoryRepository.findAll();
        Sleep sleep = new Sleep();
        model.addAttribute("categories",categories);
        model.addAttribute("sleep", sleep);
        return "sleep";
    }

    @PostMapping("/safeSleep/create")
    public String safeSleepSubmit(@ModelAttribute Sleep sleep, HttpServletRequest request) {
        if(sleep.getTitle().equals("")|| sleep.getArticle().equals("")){
            return "sleep";
        }
        String selectedTitle= request.getParameter("selectedTitle");

        System.out.println(selectedTitle);
        sleepRepository.save(sleep);
        System.out.println(sleep);
        try{
            Category category = categoryRepository.findByTitle(selectedTitle);

//            category.getArticles().add(sleep);
            System.out.println(category);
//            categoryRepository.save(category);

        }catch (Exception ex){
            return ex.toString();
        }

        return "sleep";

    }

}
