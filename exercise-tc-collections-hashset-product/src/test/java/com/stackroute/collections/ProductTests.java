package com.stackroute.collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductTests {

	private static final String MSG_01 = "check the constructor for proper initialization of properties";
	private static final String MSG_02 = "check the setters for proper assignment of property values";
    private static final String MSG_03 = "details returned by getProductDetails method is not correct or not as per required format";
    private static final String MSG_04 = "initialzing with negative price should throw InvalidPriceException";
    private static final String MSG_05 = "should be able comparable with other Products based on Price ";
    private static final String MSG_06 = "should be equaled based on all properties of object";
    private Product product;
    
    @BeforeEach
    public void setUp() throws InvalidPriceException {
        product = new Product(101, "Knife", 500);
    }
    
    @AfterEach
    public void tearDown() {
    	product = null;
    }
    
    @Test
    public void givenValidConstructorValuesForProduct() {
        assertEquals(101, product.getProductId(), MSG_01);
        assertEquals("Knife", product.getProductName(), MSG_01);
        assertEquals(500.00, product.getPrice(), MSG_01);
    }
    
    @Test
    public void givenNegativePriceForProductThrowsException() throws InvalidPriceException {
    	assertThrows(InvalidPriceException.class, () -> product =  new Product(101,"Test Skill",-900), MSG_04);
    }
    
    @Test
    public void checkOverriddedCompareToResultForProduct() throws InvalidPriceException  {
    	Product prod = new Product(103,"Chair",1000.0);
    	ArrayList<Product> output = new ArrayList<>();
    	output.add(product);
    	output.add(prod);	
    	ArrayList<Product> list = new ArrayList<>();
    	list.add(prod);
    	list.add(product);
    	Collections.sort(list);
    	 assertEquals(output,list, MSG_05);
    }
    
    @Test
    public void checkOverriddedEqualsMethodForProduct() throws InvalidPriceException {
    	Product prod = new Product(101,"Knife",500);
    	assertEquals(true,product.equals(prod),MSG_06);
    }
    
    @Test
    public void checkOverriddedEqualsMethodForNullProduct() throws InvalidPriceException {
    	Product prod = null;
    	assertEquals(false,product.equals(prod),MSG_06);
    }
    
    @Test
    public void changeProductNameValueForProduct() {
       product.setProductName("Knife Set");
       assertEquals("Knife Set", product.getProductName(), MSG_02);
    }
    
    @Test
    public void givenProductObjectThenGetProductDetails() {
        var productDetails = product.toString();
        var expectedDetails = "Product{productId=101, productName=Knife, price=500.0}";
        final var regex = "//s+";
        assertEquals(expectedDetails.toLowerCase().replaceAll(regex, " "), productDetails.toLowerCase().replaceAll(regex, " "), MSG_03);
    }

}
