package com.stackroute.collections;

import java.util.Objects;

/*
Class Product has three fields- productId, productName and price
This class is of comparable type which compares by price
 */
public class Product implements Comparable<Product> {
    private int productId;
    private String productName;
    private double price;

    /*
    Parameterized constructor
     */
    public Product(int productId, String productName, double price) throws InvalidPriceException {
        this.productId = productId;
        this.productName = productName;
        if (price > 0) {
            this.price = price;
        } else {
            throw new InvalidPriceException("Product price should be greater than zero");
        }
    }

    // Overrides toString function to represent Product objects in string format
    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName=" + productName +
                ", price=" + price +
                '}';
    }

    public int getProductId() {
        return productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    //Overrides equals for checking the equality of product objects
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Product product = (Product) object;
        return productId == product.productId &&
                Double.compare(product.price, price) == 0 &&
                productName.equals(product.productName);
    }

    // Overrides hashcode which is mandatory when we override equals method
    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, price);
    }

    // Overrides compareTo for comparing products based on price property
    @Override
    public int compareTo(Product product) {
        return (int) (this.price - product.price);
    }
}
