package com.example.demo.employee.demo2.AmazonSearch;


import java.util.ArrayList;
import java.util.List;

public class Product {
    private String name;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private double price;

    public List<Product> getProductList(){
        List<Product> products=new ArrayList<>();

        products.add(new Product("Nutella",5.99));
        products.add(new Product("Laptop",15000.99));
        products.add(new Product("Peanut Butter",40.99));

        return products;

    }
}
