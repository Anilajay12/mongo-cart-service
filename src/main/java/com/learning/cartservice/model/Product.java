package com.learning.cartservice.model;

public class Product {

    private int productId;
    private String productName;
    private Barcode barcode;


    public Product() {
    }

    public Product(int productId, String productName, Barcode barcode) {
        this.productId = productId;
        this.productName = productName;
        this.barcode = barcode;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Barcode getBarcode() {
        return barcode;
    }

    public void setBarcode(Barcode barcode) {
        this.barcode = barcode;
    }


    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", barcode=" + barcode +
                '}';
    }
}
