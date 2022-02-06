package com.example.shopofmusictools.controllers;


import com.example.shopofmusictools.models.Producer;
import com.example.shopofmusictools.services.ProducerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProducerController {

    private final ProducerService producerService;

    public ProducerController(ProducerService producerService) {
        this.producerService = producerService;
    }


    @GetMapping("/viewAllProducers")
    public ModelAndView viewAllProducers() {
        List<Producer> producers = producerService.getAllProducer();

        return new ModelAndView("viewAllProducers", "list", producers);
    }

    @GetMapping("/addProducer")
    public ModelAndView addProducer(){
        return new ModelAndView("addProducer", "command", new Producer());
    }

    @PostMapping("/saveProducer")
    public ModelAndView saveProducer(@ModelAttribute Producer producer){
        producerService.addProducer(producer.getName(),producer.getCountry());
        return new ModelAndView("redirect:/viewAllProducers");
    }

    @GetMapping("/deleteProducer/{id}")
    public ModelAndView deleteProducer(@PathVariable int id){
        producerService.removeProducer(id);
        return new ModelAndView("redirect:/viewAllProducers");
    }

    @RequestMapping(value = "/updateProducer/{id}", method = RequestMethod.GET)
    public ModelAndView updateProducer(@PathVariable int id){
        Producer producer = null;
        for (Producer temp: producerService.getAllProducer()){
            if(temp.getId() == id){
                producer = temp;
            }
        }
        return new ModelAndView("updateProducer", "command",producer);
    }
}
