package com.example.shopofmusictools.repositories;

import com.example.shopofmusictools.models.Category;
import com.example.shopofmusictools.models.Producer;
import com.example.shopofmusictools.models.Tool;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToolRepository {

    void addTool(String model, String title, int price,String currency, Category category, Producer producer);
    void removeTool(int id);
    void updateTool(int id, String model, String title, int price, Category category, Producer producer);
    List<Tool> getAllTool();
}
