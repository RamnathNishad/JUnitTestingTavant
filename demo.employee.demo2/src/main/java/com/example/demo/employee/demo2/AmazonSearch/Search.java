package com.example.demo.employee.demo2.AmazonSearch;

public class Search {
    public String displayProduct(Product product){
        for (Product p:product.getProductList()){
            if(p.getName().equalsIgnoreCase(product.getName())){
                return p.getName();
            }
        }
        return null;
    }
}


