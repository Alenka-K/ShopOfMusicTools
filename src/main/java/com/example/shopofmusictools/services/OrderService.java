package com.example.shopofmusictools.services;

import com.example.shopofmusictools.DataSourceConfig;
import com.example.shopofmusictools.models.Category;
import com.example.shopofmusictools.models.Customer;
import com.example.shopofmusictools.models.Order;
import com.example.shopofmusictools.models.Tool;
import com.example.shopofmusictools.repositories.OrderRepository;
import org.springframework.stereotype.Service;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class OrderService implements OrderRepository {

    private final DataSource dataSource = DataSourceConfig.dataSource();

    private final CustomerService customerService;
    private final ToolService toolService;

    public OrderService(CustomerService customerService, ToolService toolService) {
        this.customerService = customerService;
        this.toolService = toolService;
    }

    public Order getOrderById(int id){
        Order order = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM LAB2_EK_ORDERS WHERE ORD_ID = ?")) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while ((resultSet.next())) {
                    order = parseOrder(resultSet);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return order;
    }


    @Override
    public void addOrder(Customer customer, Tool tool, int quantity) {
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO LAB2_EK_ORDERS (CUST_ID, ORD_DATE, TOOL_ID, ORD_QUANTITY) VALUES (:1, :2, :3, :4)")) {
            preparedStatement.setInt(1, customer.getId());
            preparedStatement.setDate(2, date);
            preparedStatement.setInt(3, tool.getId());
            preparedStatement.setInt(4, quantity);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeOrder(int id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE LAB2_EK_ORDERS WHERE ORD_ID = ?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateOrder(int id, int quantity) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE LAB2_EK_ORDERS SET ORD_QUANTITY =:1 WHERE ORD_ID = :2")) {
            preparedStatement.setInt(1, quantity);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Order> getAllOrder() {
        List<Order> orders = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM LAB2_EK_ORDERS order by ORD_ID");
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while ((resultSet.next())) {
                orders.add(parseOrder(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;

    }

    private Order parseOrder(ResultSet resultSet) {
        Order order = null;
        try {
            int ord_id = resultSet.getInt("ORD_ID");
            int cust_id = resultSet.getInt("CUST_ID");
            List<Customer> customers = customerService.getAllCustomer();
            Customer customer = null;
            for (Customer tempCust: customers) {
                if(tempCust.getId() == cust_id){
                    customer = tempCust;
                }
            }
            Date ord_date = resultSet.getDate("ORD_DATE");
            int tool_id = resultSet.getInt("TOOL_ID");
            List<Tool> tools = toolService.getAllTool();
            Tool tool = null;
            for (Tool tempTool: tools) {
                if(tempTool.getId() == cust_id){
                    tool = tempTool;
                }
            }
            int ord_quantity = resultSet.getInt("ORD_QUANTITY");
            order = new Order(ord_id, customer, ord_date, tool, ord_quantity);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return order;
    }
}
