package com.example.shopofmusictools.models;


import java.io.Serializable;

public class Tool implements Serializable {

    private int id;
    private String model;
    private String title;
    private int price;
    private Category category;
    private Producer producer;

    public Tool() {
    }

    public Tool(int id, String model, String title, int price, Category category, Producer producer) {
        this.id = id;
        this.model = model;
        this.title = title;
        this.price = price;
        this.category = category;
        this.producer = producer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    @Override
    public String toString() {
        return model + title;
    }
}





