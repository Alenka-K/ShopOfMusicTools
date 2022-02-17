package com.example.shopofmusictools.services;

import com.example.shopofmusictools.DataSourceConfig;
import com.example.shopofmusictools.models.Category;
import com.example.shopofmusictools.repositories.CategoryRepository;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Service
public class CategoryService implements CategoryRepository {

    private static final Logger logger = Logger.getLogger(CategoryService.class);

    private final DataSourceConfig dataSourceConfig;

    public CategoryService(DataSourceConfig dataSourceConfig) {
        this.dataSourceConfig = dataSourceConfig;
    }

    public Category getCategoryById(int id){
        Category category = null;
        try (Connection connection = dataSourceConfig.dataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM LAB2_EK_CATEGORIES WHERE CAT_ID = :1")) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while ((resultSet.next())) {
                    category = parseCategory(resultSet);
                }
            }
        } catch (SQLException throwables) {
            logger.error(throwables.getStackTrace());
        }
        return category;
    }

    @Override
    public void addCategory(String name, int discount) {
        try (Connection connection = dataSourceConfig.dataSource().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO LAB2_EK_CATEGORIES (CAT_NAME, CAT_DISCOUNT) VALUES (:1, :2)")) {
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, discount);
            preparedStatement.execute();
        } catch (SQLException e) {
            logger.error(e.getStackTrace());
        }
    }

    @Override
    public void removeCategory(int id) {
        try (Connection connection = dataSourceConfig.dataSource().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE LAB2_EK_CATEGORIES WHERE CAT_ID = ?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            logger.error(e.getStackTrace());
        }
    }

    @Override
    public void updateCategory(int id, String name, int discount) {
        try (Connection connection = dataSourceConfig.dataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE LAB2_EK_CATEGORIES SET CAT_NAME = :1, CAT_DISCOUNT = :2 WHERE CAT_ID = :3")) {
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, discount);
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.getStackTrace());
        }
    }

    @Override
    public List<Category> getAllCategory() {
        List<Category> categories = new ArrayList<>();
        try (Connection connection = dataSourceConfig.dataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM LAB2_EK_CATEGORIES order by CAT_ID");
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while ((resultSet.next())) {
               categories.add(parseCategory(resultSet));
            }
        } catch (SQLException e) {
            logger.error(e.getStackTrace());
        }
        return categories;
    }


    private Category parseCategory(ResultSet resultSet){
        Category category = null;
        try{
            int cat_id = resultSet.getInt("CAT_ID");
            String cat_name = resultSet.getString("CAT_NAME");
            int cat_discount = resultSet.getInt("CAT_DISCOUNT");
            category = new Category(cat_id, cat_name, cat_discount);
        } catch (SQLException throwables) {
            logger.error(throwables.getStackTrace());
        }
        return category;
    }
}
