package com.example.shopofmusictools.services;

import com.example.shopofmusictools.DataSourceConfig;
import com.example.shopofmusictools.models.Producer;
import com.example.shopofmusictools.repositories.ProducerRepository;
import org.springframework.stereotype.Service;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Service
public class ProducerService implements ProducerRepository {

    private final DataSource dataSource = DataSourceConfig.dataSource();

    @Override
    public void addProducer(String name, String country) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO LAB2_EK_PRODUCER (PROD_NAME, PROD_COUNTRY) VALUES (:1, :2)")) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, country);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeProducer(int id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE LAB2_EK_PRODUCER WHERE PROD_ID = ?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateProducer(int id, String name, String country) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE LAB2_EK_PRODUCER SET PROD_NAME = :1, PROD_COUNTRY =:2 WHERE PROD_ID = :3")) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, country);
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Producer> getAllProducer() {
        List<Producer> producers = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM LAB2_EK_PRODUCER order by PROD_ID");
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while ((resultSet.next())) {
                producers.add(parseProducer(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return producers;
    }

    private Producer parseProducer(ResultSet resultSet) {
        Producer producer = null;
        try {
            int prod_id = resultSet.getInt("PROD_ID");
            String prod_name = resultSet.getString("PROD_NAME");
            String prod_country = resultSet.getString("PROD_COUNTRY");
            producer = new Producer(prod_id, prod_name, prod_country);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return producer;
    }
}
