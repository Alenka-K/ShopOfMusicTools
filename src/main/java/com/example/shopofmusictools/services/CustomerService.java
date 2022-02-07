package com.example.shopofmusictools.services;

import com.example.shopofmusictools.DataSourceConfig;
import com.example.shopofmusictools.models.Customer;
import com.example.shopofmusictools.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService implements CustomerRepository {

    private final DataSource dataSource = DataSourceConfig.dataSource();

    @Override
    public List<Customer> getAllCustomer() {
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM LAB2_EK_CUSTOMER order by CUST_ID");
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while ((resultSet.next())) {
                customers.add(parseCustomer(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;

    }

    @Override
    public void addCustomer(String name, String phone) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO LAB2_EK_CUSTOMER (CUST_NAME, CUST_PHONE) VALUES (:1, :2)")) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, phone);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeCustomer(int id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE LAB2_EK_CUSTOMER WHERE CUST_ID = ?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCustomer(int id, String name, String phone) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE LAB2_EK_CUSTOMER SET CUST_NAME =:1, CUST_PHONE = :2 WHERE CUST_ID = :3")) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, phone);
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Customer parseCustomer(ResultSet resultSet) {
        Customer customer = null;
        try {
            int cust_id = resultSet.getInt("CUST_ID");
            String cust_name = resultSet.getString("CUST_NAME");
            String cust_phone = resultSet.getString("CUST_PHONE");
            customer = new Customer(cust_id, cust_name, cust_phone);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customer;
    }

    public Customer getCustomerById(int id) {
        Customer customer = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM LAB2_EK_CUSTOMER WHERE CUST_ID = ?")) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while ((resultSet.next())) {
                    customer = parseCustomer(resultSet);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customer;
    }
}
