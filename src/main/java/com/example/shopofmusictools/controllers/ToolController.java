package com.example.shopofmusictools.controllers;


import com.example.shopofmusictools.CurrencyRateRequester;
import com.example.shopofmusictools.models.Category;
import com.example.shopofmusictools.models.Producer;
import com.example.shopofmusictools.models.Tool;
import com.example.shopofmusictools.services.CategoryService;
import com.example.shopofmusictools.services.ProducerService;
import com.example.shopofmusictools.services.ToolService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class ToolController {

    private final ToolService toolService;

    private final CategoryService categoryService;

    private final ProducerService producerService;

    private final CurrencyRateRequester currencyRateRequester;

    public ToolController(ToolService toolService, CategoryService categoryService, ProducerService producerService, CurrencyRateRequester currencyRateRequester) {
        this.toolService = toolService;
        this.categoryService = categoryService;
        this.producerService = producerService;
        this.currencyRateRequester = currencyRateRequester;
    }
    

    @GetMapping("/viewAllTools")
    public String viewAllTools(Model model) {
        List<Tool> tools = toolService.getAllTool();
        Map<String, Float> rates = new HashMap<>();
        for (Tool tool : tools ) {
            float rate = currencyRateRequester.getCurrencyRate(tool);
            rates.put(tool.getCurrency(), rate);
        }
        model.addAttribute("list", tools);
        model.addAttribute("listRates", rates);
        return "viewAllTools";
    }

    @GetMapping("/addTool")
    public String addTool(Model model){
        model.addAttribute("categoryList", categoryService.getAllCategory());
        model.addAttribute("producerList", producerService.getAllProducer());
        model.addAttribute("currencyCodeList", Currency.getAvailableCurrencies().toArray());
        model.addAttribute("command", new Tool());
        return "addTool";
    }

    @PostMapping("/saveTool")
    public String saveTool(@RequestParam("model") String model,
                                 @RequestParam("title") String title,
                                 @RequestParam("price") int price,
                                 @RequestParam("currency") String currency,
                                 @RequestParam("category") int cat_id,@RequestParam("producer") int prod_id){
        Category cat = categoryService.getCategoryById(cat_id);
        Producer prod = producerService.getProducerById(prod_id);
        toolService.addTool(model, title, price, currency, cat, prod);
        return "redirect:/viewAllTools";
    }

    @GetMapping("/updateTool/{id}")
    public String updateTool(@PathVariable int id, Model model){
        Tool tool = toolService.getToolById(id);
        model.addAttribute("categoryList", categoryService.getAllCategory());
        model.addAttribute("producerList", producerService.getAllProducer());
        model.addAttribute("command", tool);
        return "updateTool";
    }

    @PostMapping("/saveUpdateTool")
    public String saveUpdateTool(@RequestParam("id") int id,
                            @RequestParam("model") String model,
                            @RequestParam("title") String title,
                            @RequestParam("price") int price,
                            @RequestParam("category") int cat_id,
                            @RequestParam("producer") int prod_id){
        Category cat = categoryService.getCategoryById(cat_id);
        Producer prod = producerService.getProducerById(prod_id);
        toolService.updateTool(id, model,title, price, cat, prod);
        return "redirect:/viewAllTools";
    }


    @GetMapping("/deleteTool/{id}")
    public ModelAndView deleteTool(@PathVariable int id){
        toolService.removeTool(id);
        return new ModelAndView("redirect:/viewAllTools");
    }
}
