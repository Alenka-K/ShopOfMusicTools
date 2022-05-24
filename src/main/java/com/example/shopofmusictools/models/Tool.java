package com.example.shopofmusictools.models;


import java.io.Serializable;

public class Tool implements Serializable {

    private int id;
    private String model;
    private String title;
    private int price;
    private String currency;
    private Category category;
    private Producer producer;

    public Tool() {
    }

    public Tool(int id, String model, String title, int price, String currency, Category category, Producer producer) {
        this.id = id;
        this.model = model;
        this.title = title;
        this.price = price;
        this.currency = currency;
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

    public String getCurrency() { return currency; }

    public void setCurrency(String currency) {
        this.currency = currency;
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
        return "Tool{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", currency='" + currency + '\'' +
                ", category=" + category.getName() +
                ", producer=" + producer.getName() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tool tool = (Tool) o;

        if (id != tool.id) return false;
        if (price != tool.price) return false;
        if (model != null ? !model.equals(tool.model) : tool.model != null) return false;
        if (title != null ? !title.equals(tool.title) : tool.title != null) return false;
        if (currency != null ? !currency.equals(tool.currency) : tool.currency != null) return false;
        if (category != null ? !category.equals(tool.category) : tool.category != null) return false;
        return producer != null ? producer.equals(tool.producer) : tool.producer == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + price;
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (producer != null ? producer.hashCode() : 0);
        return result;
    }
}





