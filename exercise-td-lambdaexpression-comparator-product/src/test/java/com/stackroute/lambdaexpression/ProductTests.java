package com.stackroute.lambdaexpression;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductTests {
    private static final String MESSAGE_ONE = "Product properties are not set correctly in the constructor";
    private static final String MESSAGE_TWO = "Product details returned by toString() are not correct";

    private Product product;

    @BeforeEach
    public void setUp() {
        product = new Product(1, "Electronics", "Samsung S10 Mobile", 35000);
    }

    @AfterEach
    public void tearDown() {
        product = null;
    }

    @Test
    public void givenValidProductValuesWhenCreatedThenSetProperties() {
        assertEquals(1, product.getId(), MESSAGE_ONE);
        assertEquals("Electronics", product.getCategory(), MESSAGE_ONE);
        assertEquals("Samsung S10 Mobile", product.getName(), MESSAGE_ONE);
        assertEquals(35000.0, product.getPrice(), MESSAGE_ONE);
    }


    @Test
    public void givenValidProductDetailsThenReturnProductDetails() {
        String details = product.toString();
        assertTrue(details.contains("id=1, category='Electronics', name='Samsung S10 Mobile', price=35000.0"), MESSAGE_TWO);
    }


}
