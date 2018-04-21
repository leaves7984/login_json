package com.example.easynotes.webController;


import com.example.easynotes.model.Category;
import com.example.easynotes.model.SleepTips;
import com.example.easynotes.repository.CategoryRepository;
import com.example.easynotes.repository.SleepTipsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
public class WebCategoryController {

    @Autowired
    CategoryRepository categoryRepository;


    @GetMapping("/category/create")
    public String SleepTipsForm(Model model) {
        Category category = new Category();
        System.out.println(category.getId());

        model.addAttribute("category", category);
        return "category";
    }

    @PostMapping("/category/create")
    public String SleepTipsSubmit(@ModelAttribute Category category) {
        categoryRepository.save(category);
        System.out.println(category);
        return "category";
    }
}
