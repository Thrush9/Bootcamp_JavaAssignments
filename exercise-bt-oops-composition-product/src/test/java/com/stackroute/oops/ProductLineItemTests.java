package com.stackroute.oops;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProductLineItemTests {


    private static final String INITIALIZE_OBJECT_MESSAGE = "check the constructor for proper initialization of properties";
    private static final String SET_OBJECT_PROPERTIES_MESSAGE = "check the setters for proper assignment of property values";
    private static final String PRODUCT_DETAILS_MESSAGE = "details returned by getBookDetails method is not correct or not as per required format";

    private Product product;
    private ProductLineItem productLineItem;

    @BeforeEach
    public void setUp() {
        product = new Product(1, "Television", "This is lED TV");
        productLineItem = new ProductLineItem(1, 10, product);
    }

    @AfterEach
    public void tearDown() {
        product = null;
        productLineItem = null;
    }

    @Test
    public void givenValidPropertyValuesWhenProductLineItemObjectCreatedThenPropertiesAreSet() {
        assertEquals(1, productLineItem.getId(), INITIALIZE_OBJECT_MESSAGE);
        assertEquals(10, productLineItem.getQuantity(), INITIALIZE_OBJECT_MESSAGE);
        assertEquals("This is lED TV", product.getDescription(), INITIALIZE_OBJECT_MESSAGE);
        assertNotNull(productLineItem.getProduct(), INITIALIZE_OBJECT_MESSAGE);
    }

    @Test
    public void givenProductLineItemObjectWhenPropertyValuesAreChangedBySettersThenPropertiesAreSet() {

        productLineItem.setQuantity(20);
        assertEquals(20, productLineItem.getQuantity(), SET_OBJECT_PROPERTIES_MESSAGE);

    }

    @Test
    public void givenProductLineItemObjectThenGetItemDetails() {
        var lineItem = productLineItem.getItemDetails();
        var expectedDetails = "productLineItem{id=1,quantity=10,product=Product{id=1, name='Television', description='This is LED TV'}}";
        final var regex = "//s+";
        assertEquals(expectedDetails.toLowerCase().replaceAll(regex, " "), lineItem.toLowerCase().replaceAll(regex, " "), PRODUCT_DETAILS_MESSAGE);
    }
}
