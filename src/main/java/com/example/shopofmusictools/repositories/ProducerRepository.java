package com.example.shopofmusictools.repositories;


import com.example.shopofmusictools.models.Producer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProducerRepository {

    void addProducer(String name, String country);
    void removeProducer(int id);
    void updateProducer(int id, String name, String country);
    List<Producer> getAllProducer();
}
