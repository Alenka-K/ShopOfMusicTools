package com.example.shopofmusictools.controllers;


import com.example.shopofmusictools.models.*;
import com.example.shopofmusictools.services.CustomerService;
import com.example.shopofmusictools.services.OrderService;
import com.example.shopofmusictools.services.ToolService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;
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
        return new ModelAndView("viewAllOrders", "list", orders);
    }

    @RequestMapping("/addOrder/{id}")
    public ModelAndView addOrder(@PathVariable int id, ModelAndView model){
        List<Customer> customerList = customerService.getAllCustomer();
        model.addObject("customerList", customerList);
       Order order = new Order();
       Tool tool = toolService.getToolById(id);
       model.addObject("tool", tool);
       order.setTool(tool);
       model.addObject("command", order);
        model.setViewName("./addOrder");
        return model;
    }

    @PostMapping("/saveOrder")
    public ModelAndView saveOrder(@ModelAttribute("command") @Valid Order order, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return new ModelAndView("/addOrder", "customerList", customerService.getAllCustomer());
        }else {
            System.out.println(order.getTool());
            orderService.addOrder(order.getCustomer(),order.getTool(),order.getQuantity());
        }
        return new ModelAndView("redirect:/viewAllOrders");
    }

    @RequestMapping(value="/updateOrder/{id}", method = RequestMethod.GET)
    public ModelAndView updateOrder(@PathVariable int id){
        Order order = orderService.getOrderById(id);
        return new ModelAndView("/updateOrder", "command", order);
    }

    @PostMapping("/saveUpdateOrder")
    public ModelAndView saveUpdateOrder(@ModelAttribute("command") @Valid Order order, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("/updateOrder");
        }else {
            orderService.updateOrder(order.getId(), order.getQuantity());
        }
        return new ModelAndView("redirect:/viewAllOrders");
    }

    @GetMapping("/deleteOrder/{id}")
    public ModelAndView deleteOrder(@PathVariable int id){
        orderService.removeOrder(id);
        return new ModelAndView("redirect:/viewAllOrders");
    }

}
