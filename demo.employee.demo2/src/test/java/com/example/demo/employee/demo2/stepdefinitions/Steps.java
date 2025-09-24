package com.example.demo.employee.demo2.stepdefinitions;

import com.example.demo.employee.demo2.AmazonSearch.Product;
import com.example.demo.employee.demo2.AmazonSearch.Search;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Steps {

    Product product;
    Search search;

    @Given("I have a search field on the Amazon page")
    public void i_have_a_search_field_on_the_amazon_page() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        System.out.println("I have a search field on the amazon page");
    }

    @When("I search for {string}")
    public void i_search_for_laptop(String string) {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        System.out.println("I search for " + string);
        product=new Product("Laptop",15000.99);
    }

    @And("Price is greater than 10000")
    public void price_is_greater_than_10000(){
        if(product.getPrice()>10000) {
            System.out.println("This product price is greater than 10000");
        }else{
            System.out.println("Product price is not above 10000");
        }
    }

    @Then("I expect a laptop related results")
    public void i_expect_a_laptop_related_results() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        System.out.println("I expect a laptop related results");

        search=new Search();
        String result = search.displayProduct(product);

        if(result!=null){
            System.out.println("Product found:" + result);
            assertEquals("Laptop",result);
        }else{
            System.out.println("Product not found");

        }
    }
}
