package com.example.shopofmusictools.controllers;


import com.example.shopofmusictools.models.*;
import com.example.shopofmusictools.services.CustomerService;
import com.example.shopofmusictools.services.OrderService;
import com.example.shopofmusictools.services.ToolService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class OrderController {

    private final OrderService orderService;
    private final ToolService toolService;
    private final CustomerService customerService;

    public OrderController(OrderService orderService, ToolService toolService, CustomerService customerService) {
        this.orderService = orderService;
        this.toolService = toolService;
        this.customerService = customerService;
    }

    @GetMapping("/viewAllOrders")
    public ModelAndView viewAllOrders() {
        List<Order> orders = orderService.getAllOrder();
        List<Tool> tools = toolService.getAllTool();
        return new ModelAndView("viewAllOrders", "list", orders);
    }

    @RequestMapping("/addOrder/{id}")
    public String addOrder(@PathVariable int id, Model model){
        model.addAttribute("customerList", customerService.getAllCustomer());
        Order order = new Order();
        model.addAttribute("tool", toolService.getToolById(id));
        order.setTool(toolService.getToolById(id));
        model.addAttribute("command", order);
        return "./addOrder"; //new ModelAndView("addOrder", "command", new Order());
    }

    @RequestMapping("/saveOrder")
    public ModelAndView saveCategory(@RequestParam("customer") int customer_id,
                                     @RequestParam("tool") int tool_id,
                                     @RequestParam("quantity") int quantity){
        Customer customer = customerService.getCustomerById(customer_id);
        Tool tool = toolService.getToolById(tool_id);
        orderService.addOrder(customer, tool, quantity);
        return new ModelAndView("redirect:/viewAllOrders");
    }

    @RequestMapping("/updateOrder/{id}")
    public ModelAndView updateOrder(@PathVariable int id){
        Order order = orderService.getOrderById(id);
        return new ModelAndView("./updateOrder", "command", order);
    }

    @PostMapping("/saveUpdateOrder")
    public ModelAndView saveUpdate(@RequestParam("id") int id,
                                   @RequestParam("quantity") int quantity){
        orderService.updateOrder(id, quantity);
        return new ModelAndView("redirect:/viewAllOrders");
    }

    @GetMapping("/deleteOrder/{id}")
    public ModelAndView deleteOrder(@PathVariable int id){
        orderService.removeOrder(id);
        return new ModelAndView("redirect:/viewAllOrders");
    }
}
