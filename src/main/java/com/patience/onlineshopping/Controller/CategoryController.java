package com.patience.onlineshopping.Controller;

import com.patience.onlineshopping.DTO.CategoryDTO;
import com.patience.onlineshopping.Entity.Category;
import com.patience.onlineshopping.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/admin/category")
    public String getCategory(Model model){
        model.addAttribute("categories", categoryService.getAllCategory() );
        return "Category/ViewCategory";
    }

    @GetMapping("/admin/addCategory")
    public String getCategoryAdd(Model model){
        model.addAttribute("categoryDTO", new CategoryDTO() );
        return "Category/AddCategory";
    }

    @PostMapping("/admin/addCategory")
    public String postCategoryAdd(@ModelAttribute("categoryDTO") CategoryDTO categoryDTO){
        Category category=new Category();
        category.setCategoryId(categoryDTO.getCategoryId());
        category.setName(categoryDTO.getName());
        category.setDescription(categoryDTO.getDescription());

        categoryService.save(category);

        return "redirect:/admin/category";
    }

    @GetMapping("admin/deleteCategory/{id}")
    public String deleteCategory(@PathVariable  Integer id){
        categoryService.removeCategoryById(id);
        return "redirect:/admin/category";
    }

    @GetMapping("admin/updateCategory/{id}")
    public String updateCategory(@PathVariable int id, Model model){
        Optional<Category> category = categoryService.findCategoryById(id);
        if(category.isPresent()){
            CategoryDTO categoryDTO=new CategoryDTO();
            categoryDTO.setCategoryId(category.get().getCategoryId());
            categoryDTO.setName(category.get().getName());
            categoryDTO.setDescription(category.get().getDescription());

            model.addAttribute("categoryDTO",categoryDTO);
            return "Category/AddCategory";
        }
        return "404";
    }
}
