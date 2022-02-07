package com.example.shopofmusictools.controllers;
import com.example.shopofmusictools.models.Category;
import com.example.shopofmusictools.services.CategoryService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {

        this.categoryService = categoryService;
    }

    @GetMapping("/showCategory/{id}")
    public ModelAndView showCategory(@PathVariable int id) {
        Category category = categoryService.getCategoryById(id);
        return new ModelAndView("showCategory", "category", category);
    }

    @GetMapping("/viewAllCategories")
    public ModelAndView viewAllCategories() {
        List<Category> categories = categoryService.getAllCategory();

        return new ModelAndView("viewAllCategories", "list", categories);
    }

    @GetMapping("/addCategory")
    public ModelAndView addCategory(){

        return new ModelAndView("addCategory", "command", new Category());
    }

    @PostMapping("/saveCategory")
    public ModelAndView saveCategory(@ModelAttribute Category category){
        categoryService.addCategory(category.getName(),category.getDiscount());
        return new ModelAndView("redirect:/viewAllCategories");
    }

    @RequestMapping("/updateCategory/{id}")
    public ModelAndView updateCategory(@PathVariable int id){
        Category category = categoryService.getCategoryById(id);
        return new ModelAndView("./updateCategory", "command", category);
    }
    @PostMapping("/saveUpdate")
    public ModelAndView saveUpdate(@ModelAttribute Category category){
        categoryService.updateCategory(category.getId(),category.getName(),category.getDiscount());
        return new ModelAndView("redirect:/viewAllCategories");
    }
    @GetMapping("/deleteCategory/{id}")
    public ModelAndView deleteCategory(@PathVariable int id){
        categoryService.removeCategory(id);
        return new ModelAndView("redirect:/viewAllCategories");
    }

}
