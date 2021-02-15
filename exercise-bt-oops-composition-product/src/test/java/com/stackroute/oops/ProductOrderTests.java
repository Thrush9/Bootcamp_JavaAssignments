package com.stackroute.oops;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProductOrderTests {

    private static final String INITIALIZE_OBJECT_MESSAGE = "check the constructor for proper initialization of properties";
    private static final String SET_OBJECT_PROPERTIES_MESSAGE = "check the setters for proper assignment of property values";
    private static final String INITIAL_PRODUCT_LINE_ITEMS_MESSAGE = "initially lineitems list is empty untill they are explicitly added";
    private static final String ADD_PRODUCT_LINE_ITEMS_MESSAGE = "check the  list after  adding the productlineitems,thus ProductOrder HAS_A Product LineItem ";
    private static final String GET_PRODUCT_LINE_ITEMS_MESSAGE = "get the  list to check if the items are properly added to the order";
    private static final String REMOVE_PRODUCT_LINE_ITEMS_MESSAGE = "check the  list after  removing the item with positive index";
    private static final String REMOVE_PRODUCT_LINE_ITEMS_NEGATIVE_INDEX = "index cannot be negetive,please pass the valid index";
    private static final String ORDER_REMOVED_MESSAGE = "LineItems exist only if orders exist due to composition";

    private Product firstProduct;
    private Product secondProduct;
    private ProductOrder productOrder;
    private List<ProductLineItem> lineItems;


    @BeforeEach
    public void setUp() {
        firstProduct = new Product(1, "Television", "This is lED TV");
        secondProduct = new Product(1, "Sofa", "This is sofa");
        productOrder = new ProductOrder(1, "#ODR1001");

    }

    @AfterEach
    public void tearDown() {
        firstProduct = null;
        secondProduct = null;
        productOrder = null;
    }

    @Test
    public void givenValidPropertyValuesWhenProductOrderObjectCreatedThenPropertiesAreSet() {
        assertEquals(1, productOrder.getId(), INITIALIZE_OBJECT_MESSAGE);
        assertEquals("#ODR1001", productOrder.getName(), INITIALIZE_OBJECT_MESSAGE);
        assertEquals(0, productOrder.getLineItems().size(), INITIAL_PRODUCT_LINE_ITEMS_MESSAGE);
    }

    @Test
    public void givenProductOrderObjectWhenPropertyValuesAreChangedBySettersThenPropertiesAreSet() {

        productOrder.setId(1);
        productOrder.setName("#ORDER1001");
        assertEquals(1, productOrder.getId(), SET_OBJECT_PROPERTIES_MESSAGE);
        assertEquals("#ORDER1001", productOrder.getName(), SET_OBJECT_PROPERTIES_MESSAGE);

    }

    @Test
    public void givenProductOrderObjectThenAddLineItemsToOrder() {

        productOrder.addItem(-1, 10, firstProduct);
        productOrder.addItem(2, 10, secondProduct);
        assertEquals(2, productOrder.getLineItems().size(), ADD_PRODUCT_LINE_ITEMS_MESSAGE);

    }

    @Test
    public void givenProductOrderObjectThenGetLineItemsFromOrder() {

        productOrder.addItem(-1, 10, firstProduct);
        productOrder.addItem(2, 10, secondProduct);

        List<ProductLineItem> items = productOrder.getLineItems();
        assertEquals(items.toString(), productOrder.getLineItems().toString(), GET_PRODUCT_LINE_ITEMS_MESSAGE);

    }

    @Test
    public void givenProductOrderObjectThenRemoveLineItemsFromOrder() {

        productOrder.addItem(1, 10, firstProduct);
        productOrder.addItem(2, 10, secondProduct);


        Assertions.assertEquals("LineItem removed successfully", productOrder.removeItemById(1), REMOVE_PRODUCT_LINE_ITEMS_MESSAGE);

    }

    @Test
    public void givenNegativeIndexOfLineItemThenRemoveLineItemFromOrder() {

        productOrder.addItem(1, 10, firstProduct);
        productOrder.addItem(2, 10, secondProduct);


        Assertions.assertEquals("Please pass valid itemId", productOrder.removeItemById(-1), REMOVE_PRODUCT_LINE_ITEMS_NEGATIVE_INDEX);

    }


    @Test
    public void givenProductOrderWhenObjectIsNullThenLineItemIsNullForThatOrder() {

        productOrder.addItem(1, 10, firstProduct);
        productOrder.addItem(2, 10, secondProduct);

        productOrder = null;

        Assertions.assertNull(productOrder, ORDER_REMOVED_MESSAGE);

    }


}
