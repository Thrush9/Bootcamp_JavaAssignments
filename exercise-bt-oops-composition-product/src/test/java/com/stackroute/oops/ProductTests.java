package com.stackroute.oops;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTests {

    private static final String INITIALIZE_OBJECT_MESSAGE = "check the constructor for proper initialization of properties";
    private static final String SET_OBJECT_PROPERTIES_MESSAGE = "check the setters for proper assignment of property values";
    private static final String PRODUCT_DETAILS_MESSAGE = "details returned by getProductDetails method is not correct or not as per required format";

    private Product product;

    @BeforeEach
    public void setUp() {
        product = new Product(1, "Table", "This is a wooden table");
    }

    @AfterEach
    public void tearDown() {

        product = null;
    }

    @Test
    public void givenValidPropertyValuesWhenProductObjectCreatedThenPropertiesAreSet() {
        assertEquals("Table", product.getName(), INITIALIZE_OBJECT_MESSAGE);
        assertEquals("This is a wooden table", product.getDescription(), INITIALIZE_OBJECT_MESSAGE);
    }

    @Test
    public void givenProductObjectWhenPropertyValuesAreChangedBySettersThenPropertiesAreSet() {
        product.setName("Chair");
        product.setDescription("This is a wooden chair");
        assertEquals("Chair", product.getName(), SET_OBJECT_PROPERTIES_MESSAGE);
        assertEquals("This is a wooden chair", product.getDescription(), SET_OBJECT_PROPERTIES_MESSAGE);
    }

    @Test
    public void givenProductObjectThenGetProductDetails() {
        var productDetails = product.getProductDetails();
        String expectedDetails = "Product{Id=1, name='Table', description='This is a wooden table'}";
        final var regex = "//s+";
        assertEquals(expectedDetails.toLowerCase().replaceAll(regex, " "), productDetails.toLowerCase().replaceAll(regex, " "), PRODUCT_DETAILS_MESSAGE);
    }
}
