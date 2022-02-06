package com.example.shopofmusictools.controllers;


import com.example.shopofmusictools.models.Category;
import com.example.shopofmusictools.models.Order;
import com.example.shopofmusictools.models.Tool;
import com.example.shopofmusictools.services.OrderService;
import com.example.shopofmusictools.services.ToolService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class OrderController {

    private final OrderService orderService;
    private final ToolService toolService;

    public OrderController(OrderService orderService, ToolService toolService) {
        this.orderService = orderService;
        this.toolService = toolService;
    }

    @GetMapping("/viewAllOrders")
    public ModelAndView viewAllOrders() {
        List<Order> orders = orderService.getAllOrder();
        List<Tool> tools = toolService.getAllTool();
        return new ModelAndView("viewAllOrders", "list", orders);
    }

    @GetMapping("/addOrder")
    public ModelAndView addOrder(){
        return new ModelAndView("addOrder", "command", new Order());
    }

    @PostMapping("/saveOrder")
    public ModelAndView saveCategory(@ModelAttribute Order order){
        orderService.addOrder(order.getCustomer(), order.getTool(), order.getQuantity());
        return new ModelAndView("redirect:/viewAllOrders");
    }

    @GetMapping("/deleteOrder/{id}")
    public ModelAndView deleteOrder(@PathVariable int id){
        orderService.removeOrder(id);
        return new ModelAndView("redirect:/viewAllOrders");
    }
}
