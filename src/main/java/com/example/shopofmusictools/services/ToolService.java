package com.example.shopofmusictools.services;

import com.example.shopofmusictools.DataSourceConfig;
import com.example.shopofmusictools.models.Category;
import com.example.shopofmusictools.models.Producer;
import com.example.shopofmusictools.models.Tool;
import com.example.shopofmusictools.repositories.ToolRepository;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Service
public class ToolService implements ToolRepository {
    private static final Logger logger = Logger.getLogger(ToolService.class);

    private final DataSourceConfig dataSourceConfig;
    private final CategoryService categoryService;
    private final ProducerService producerService;

    public ToolService(DataSourceConfig dataSourceConfig, CategoryService categoryService, ProducerService producerService) {
        this.dataSourceConfig = dataSourceConfig;
        this.categoryService = categoryService;
        this.producerService = producerService;
    }

    public Tool getToolById(int id) {
        Tool tool = null;
        try (Connection connection = dataSourceConfig.dataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM LAB2_EK_TOOLS WHERE TOOL_ID = :1")) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while ((resultSet.next())) {
                    tool = parseTool(resultSet);
                }
            }
        } catch (SQLException throwables) {
            logger.error(throwables.getStackTrace());
        }
        return tool;
    }

        @Override
    public void addTool(String model, String title, int price, Category category, Producer producer) {
        try (Connection connection = dataSourceConfig.dataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO LAB2_EK_TOOLS (TOOL_MODEL,TOOL_TITLE, TOOL_PRICE, CAT_ID, PROD_ID) VALUES (:1, :2, :3, :4, :5)")) {
            preparedStatement.setString(1, model);
            preparedStatement.setString(2, title);
            preparedStatement.setInt(3, price);
            preparedStatement.setInt(4, category.getId());
            preparedStatement.setInt(5, producer.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            logger.error(e.getStackTrace());
        }
    }

    @Override
    public void removeTool(int id) {
        try (Connection connection = dataSourceConfig.dataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM LAB2_EK_TOOLS WHERE TOOL_ID = :1")) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            logger.error(e.getStackTrace());
        }
    }

    @Override
    public void updateTool(int id, String model, String title, int price, Category category, Producer producer) {
        try (Connection connection = dataSourceConfig.dataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE LAB2_EK_TOOLS SET TOOL_MODEL =:1, TOOL_TITLE =:2, TOOL_PRICE =:3, CAT_ID =:4, PROD_ID =:5 WHERE TOOL_ID = :6")) {
            preparedStatement.setString(1, model);
            preparedStatement.setString(2, title);
            preparedStatement.setInt(3, price);
            preparedStatement.setInt(4, category.getId());
            preparedStatement.setInt(5, producer.getId());
            preparedStatement.setInt(6, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.getStackTrace());
        }
    }

    @Override
    public List<Tool> getAllTool() {
        List<Tool> tools = new ArrayList<>();
        try (Connection connection = dataSourceConfig.dataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM LAB2_EK_TOOLS order by TOOL_ID");
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while ((resultSet.next())) {
                tools.add(parseTool(resultSet));
            }
        } catch (SQLException e) {
            logger.error(e.getStackTrace());
        }
        return tools;
    }

    private Tool parseTool(ResultSet resultSet) {
        Tool tool = null;
        try {
            int tool_id = resultSet.getInt("TOOL_ID");
            String tool_model = resultSet.getString("TOOL_MODEL");
            String tool_title = resultSet.getString("TOOL_TITLE");
            int tool_price = resultSet.getInt("TOOL_PRICE");
            int cat_id = resultSet.getInt("CAT_ID");
            Category category = categoryService.getCategoryById(cat_id);
            int prod_id = resultSet.getInt("PROD_ID");
            List<Producer> producers = producerService.getAllProducer();
            Producer producer = null;
            for (Producer tempProducer: producers) {
                if(tempProducer.getId() == prod_id){
                    producer = tempProducer;
                }
            }
            tool = new Tool(tool_id, tool_model, tool_title, tool_price, category, producer);
        } catch (SQLException throwables) {
            logger.error(throwables.getStackTrace());
        }
        return tool;
    }

}
