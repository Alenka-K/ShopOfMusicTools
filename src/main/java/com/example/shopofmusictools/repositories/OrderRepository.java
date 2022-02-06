package com.example.shopofmusictools.repositories;

import com.example.shopofmusictools.models.Customer;
import com.example.shopofmusictools.models.Order;
import com.example.shopofmusictools.models.Tool;
import java.util.List;

public interface OrderRepository {

    void addOrder(Customer customer, Tool tool, int quantity);
    void removeOrder(int id);
    void updateOrder(int id, Customer customer, Tool tool, int quantity);
    List<Order> getAllOrder();
}
