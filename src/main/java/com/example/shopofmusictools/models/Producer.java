package com.example.shopofmusictools.models;


import java.io.Serializable;

public class Producer implements Serializable {

    private int id;
    private String name;
    private String country;

    public Producer() {
    }

    public Producer(int id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Producer producer = (Producer) o;

        if (id != producer.id) return false;
        if (name != null ? !name.equals(producer.name) : producer.name != null) return false;
        return country != null ? country.equals(producer.country) : producer.country == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }
}
