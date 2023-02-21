package com.patience.onlineshopping.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {


    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute(model);
        return "index";
    }

}
