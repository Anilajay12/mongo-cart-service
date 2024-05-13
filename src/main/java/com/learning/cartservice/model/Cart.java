package com.learning.cartservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Document
public class Cart {
    @Id
    private int cartId;
    private String cartName;
    private List<Product> productList;
    private Customer customer;

    public Cart(int cartId, String cartName, List<Product> productList, Customer customer) {
        this.cartId = cartId;
        this.cartName = cartName;
        this.productList = productList;
        this.customer = customer;
    }

    public Cart() {
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public String getCartName() {
        return cartName;
    }

    public void setCartName(String cartName) {
        this.cartName = cartName;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", cartName='" + cartName + '\'' +
                ", productList=" + productList +
                ", customer=" + customer +
                '}';
    }
}
