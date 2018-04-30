package com.example.easynotes.webController;

import com.example.easynotes.model.Category;
import com.example.easynotes.model.ST_Category;
import com.example.easynotes.model.SleepTips;
import com.example.easynotes.model.Tip;
import com.example.easynotes.repository.ST_CategoryRepository;
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
import java.util.Set;

@Controller
@RequestMapping("web")
public class WebTipController {

    @Autowired
    TipRepository tipRepository;

    @Autowired
    SleepTipsRepository sleepTipsRepository;

    @Autowired
    ST_CategoryRepository st_categoryRepository;


    @GetMapping("/tips/create")
    public String TipForm(Model model) {
        List<ST_Category> st_categories = st_categoryRepository.findAll();
//        List<SleepTips> sleepTips = sleepTipsRepository.findAll();
        Tip tip = new Tip();
        model.addAttribute("tip", tip);
        model.addAttribute("st_categories",st_categories);
        return "tip";
    }
    @PostMapping("/tips/create")
    public String SleepTipsSubmit(@ModelAttribute("tip") Tip tip, HttpServletRequest request) {

        String id= request.getParameter("selectedTitle");
        String selectedCategory = request.getParameter("selectedCategory");
        System.out.println(id);
        System.out.println(selectedCategory);
        tipRepository.save(tip);
        System.out.println(tip);
        try{
            ST_Category st_category = st_categoryRepository.findByTitle(selectedCategory);
            Set<SleepTips> sleepTipsAll = st_category.getSleepTips();
            for(SleepTips item:sleepTipsAll){
                System.out.println(item);
                if(item.getId().equals(Long.valueOf(id))){
                    System.out.println("success");
                    item.getTips().add(tip);
                    sleepTipsRepository.save(item);
                    st_categoryRepository.save(st_category);
                    System.out.println(st_category);
                }
            }



        }catch (Exception ex) {
            return ex.toString();
        }
        return "tip";
    }

}
