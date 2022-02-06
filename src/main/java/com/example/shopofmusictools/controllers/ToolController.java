package com.example.shopofmusictools.controllers;


import com.example.shopofmusictools.models.Tool;
import com.example.shopofmusictools.services.CategoryService;
import com.example.shopofmusictools.services.ProducerService;
import com.example.shopofmusictools.services.ToolService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ToolController {

    private final ToolService toolService;

    private final CategoryService categoryService;

    private final ProducerService producerService;

    public ToolController(ToolService toolService, CategoryService categoryService, ProducerService producerService) {
        this.toolService = toolService;
        this.categoryService = categoryService;
        this.producerService = producerService;
    }

    @GetMapping("/menu")
    public String viewMenu() {
        return "menu";
    }

    @GetMapping("/viewTool/{id}")
    public ModelAndView viewTool(@PathVariable int id) {
        Tool tool = toolService.getToolById(id);
        return new ModelAndView("viewTool", "tool", tool);
    }

    @GetMapping("/viewAllTools")
    public ModelAndView viewAllTools() {
        List<Tool> tools = toolService.getAllTool();
        return new ModelAndView("viewAllTools", "list", tools);
    }

    @GetMapping("/addTool")
    public String addTool(Model model){
        model.addAttribute("categoryList", categoryService.getAllCategory());
        model.addAttribute("producerList", producerService.getAllProducer());
        model.addAttribute("command", new Tool());
//        List<Category> categoryList = categoryService.getAllCategory();
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("categoryList", categoryList);
//        mav.addObject("command", new Tool());
//        mav.setViewName("addTool");
        return "addTool";
    }

    @PostMapping("/saveTool")
    public ModelAndView saveTool(@ModelAttribute Tool tool){
        toolService.addTool(tool.getModel(),tool.getTitle(), tool.getPrice(), tool.getCategory(), tool.getProducer());
        return new ModelAndView("redirect:/viewAllTools");
    }
    @GetMapping("/deleteTool/{id}")
    public ModelAndView deleteTool(@PathVariable int id){
        toolService.removeTool(id);
        return new ModelAndView("redirect:/viewAllTools");
    }
}
