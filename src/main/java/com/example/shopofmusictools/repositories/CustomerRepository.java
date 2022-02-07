package com.example.shopofmusictools.repositories;


import com.example.shopofmusictools.models.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository {

    void addCustomer(String name, String phone);
    void removeCustomer(int id);
    void updateCustomer(int id, String name, String phone);
    List<Customer> getAllCustomer();
}
