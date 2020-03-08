package com.home.SerializationTask;

import java.io.Serializable;

class Asset implements Serializable {

    private String name;
    private double price;

    public Asset(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name+" "+price;
    }
}
