package com.example.easynotes.webController;
import com.example.easynotes.model.ST_Category;
import com.example.easynotes.repository.ST_CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/web")
public class WebST_CategoryController {

    @Autowired
    ST_CategoryRepository st_categoryRepository;

    @GetMapping("/st_category")
    public String ST_SleepTips(Model model){
        List<ST_Category> st_categories = st_categoryRepository.findAll();
        model.addAttribute("st_categories",st_categories);
        return "st_category_demo";


    }
    @GetMapping("/st_category/create")
    public String ST_SleepTipsForm(Model model) {
        ST_Category st_category =new ST_Category();
        model.addAttribute("st_category", st_category);
        return "st_category";
    }

    @PostMapping("/st_category/create")
    public String ST_SleepTipsSubmit(@ModelAttribute("st_category") ST_Category st_category) {
        st_categoryRepository.save(st_category);
        System.out.println(st_category);
        return "st_category_demo";
    }
}
