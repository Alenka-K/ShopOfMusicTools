package com.example.shopofmusictools.models;


import java.sql.Date;

public class Order {

    private int id;
    private Customer customer;
    private Date date;
    private Tool tool;
    private int quantity;


    public Order() {
    }

    public Order(int id, Customer customer, Date date, Tool tool, int quantity) {
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
}
