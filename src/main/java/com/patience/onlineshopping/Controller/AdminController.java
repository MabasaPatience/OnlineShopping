package com.patience.onlineshopping.Controller;

import com.patience.onlineshopping.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/admin/")
    public String viewadminPage(Model model){
        model.addAttribute(model);
        model.addAttribute("categories", categoryService.getAllCategory() );
        return "AdminHome";
    }


}
