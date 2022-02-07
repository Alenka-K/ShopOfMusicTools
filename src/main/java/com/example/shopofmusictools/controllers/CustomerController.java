package com.example.shopofmusictools.controllers;


import com.example.shopofmusictools.models.Customer;
import com.example.shopofmusictools.services.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping("/viewAllCustomers")
    public ModelAndView viewAllCustomers() {
        List<Customer> customers = customerService.getAllCustomer();

        return new ModelAndView("viewAllCustomers", "list", customers);
    }

    @GetMapping("/addCustomer")
    public ModelAndView addCustomer(){

        return new ModelAndView("addCustomer", "command", new Customer());
    }

    @PostMapping("/saveCustomer")
    public ModelAndView saveCustomer(@ModelAttribute("command") @Valid Customer customer, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return new ModelAndView("/addCustomer");
        }else {
            customerService.addCustomer(customer.getName(), customer.getPhone());
        }
        return new ModelAndView("redirect:/viewAllCustomers");
    }

    @GetMapping("/deleteCustomer/{id}")
    public ModelAndView deleteCustomer(@PathVariable int id){
        customerService.removeCustomer(id);
        return new ModelAndView("redirect:/viewAllCustomers");
    }

    @RequestMapping(value = "/updateCustomer/{id}", method = RequestMethod.GET)
    public ModelAndView updateCustomer(@PathVariable int id){
        Customer customer = customerService.getCustomerById(id);
        return new ModelAndView("updateCustomer", "command",customer);
    }
    @PostMapping("/saveUpdateCustomer")
    public ModelAndView saveUpdateCustomer(@ModelAttribute Customer customer){
        customerService.updateCustomer(customer.getId(),customer.getName(),customer.getPhone());
        return new ModelAndView("redirect:/viewAllCustomers");
    }
}
