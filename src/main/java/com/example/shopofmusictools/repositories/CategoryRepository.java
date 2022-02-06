package com.example.shopofmusictools.repositories;



import com.example.shopofmusictools.models.Category;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CategoryRepository {

    void addCategory(String name, int discount);
    void removeCategory(int id);
    void updateCategory(int id, String name, int discount);
    List<Category> getAllCategory();

}
