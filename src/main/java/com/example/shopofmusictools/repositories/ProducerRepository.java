package com.example.shopofmusictools.repositories;

import com.example.shopofmusictools.models.Customer;
import com.example.shopofmusictools.models.Order;
import com.example.shopofmusictools.models.Producer;
import com.example.shopofmusictools.models.Tool;

import java.util.Date;
import java.util.List;

public interface ProducerRepository {

    void addProducer(String name, String country);
    void removeProducer(int id);
    void updateProducer(int id, String name, String country);
    List<Producer> getAllProducer();
}
