package com.example.shopofmusictools.models;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;


public class Category implements Serializable{

    private int id;

    private String name;

    @Min(1)
    @Max(value = 60, message = "Invalid number discount")
    private int discount;

    public Category() {
    }

    public Category(int id, String name, int discount) {
        this.id = id;
        this.name = name;
        this.discount = discount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
