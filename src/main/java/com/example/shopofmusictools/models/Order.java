package com.example.shopofmusictools.models;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.sql.Date;

public class Order implements Serializable {

    private int id;
    private Customer customer;
    private Date date;
    private Tool tool;

    @DecimalMin(value = "1", message = "Quantity can not be null")
    private int quantity;




    public Order() {
    }

    public Order(int id, Date date, Customer customer, Tool tool, int quantity) {
        this.id = id;
        this.customer = customer;
        this.date = date;
        this.tool = tool;
        this.quantity = quantity;
    }
    public Tool getTool() {
        return tool;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }

    public Customer getCustomer() {
        return customer;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", date=" + date +
                ", tool=" + tool +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (quantity != order.quantity) return false;
        if (customer != null ? !customer.equals(order.customer) : order.customer != null) return false;
        if (date != null ? !date.equals(order.date) : order.date != null) return false;
        return tool != null ? tool.equals(order.tool) : order.tool == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (tool != null ? tool.hashCode() : 0);
        result = 31 * result + quantity;
        return result;
    }
}
