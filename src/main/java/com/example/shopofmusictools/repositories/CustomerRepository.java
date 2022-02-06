package com.example.shopofmusictools.repositories;


import com.example.shopofmusictools.models.Customer;

import java.util.List;

public interface CustomerRepository {

    void addCustomer(String name, String phone);
    void removeCustomer(int id);
    void updateCustomer(int id, String phone);
    List<Customer> getAllCustomer();
}
