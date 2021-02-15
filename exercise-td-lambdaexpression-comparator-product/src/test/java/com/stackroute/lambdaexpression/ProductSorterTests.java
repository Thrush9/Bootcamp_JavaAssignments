package com.stackroute.lambdaexpression;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

public class ProductSorterTests {
    private static final String MESSAGE_ONE = "Product List should be sorted according to length of the product names";
    private static final String MESSAGE_TWO = "Product List should be sorted by names alphabetically in ascending order";
    private static final String MESSAGE_THREE = "Product List should be sorted by price in descending order";
    private static final String MESSAGE_FOUR = "Product List should be sorted by category in ascending order and then by price in ascending order";
    private static final String MESSAGE_FIVE = "Empty product list returns empty list";
    private static final String MESSAGE_SIX = "Class ProductSorter should have property of ProductList of expected type";
    private static final String MESSAGE_SEVEN = "ProductList should be empty, when ProductSorter object is created";
    private ProductSorter productSorter;
    private Product productOne, productTwo, productThree, productFour, productFive, productSix;


    @BeforeEach
    public void setUp() {
        productSorter = new ProductSorter();
    }

    @AfterEach
    public void tearDown() {
        productSorter = null;
    }

    public void addTestProductData() {
        productOne = new Product(1, "Clothing", "Men TShirt", 450);
        productTwo = new Product(2, "Clothing", "Kids Frock", 600);
        productThree = new Product(3, "Clothing", "Women Kurta", 350);
        productFour = new Product(4, "Electronics", "Samsung S10 mobile", 35000);
        productFive = new Product(5, "Electronics", "Preethi Mixer", 5000);
        productSix = new Product(6, "Toys", "Battery Toy Car", 800);
        productSorter.getProductList().add(productOne);
        productSorter.getProductList().add(productTwo);
        productSorter.getProductList().add(productThree);
        productSorter.getProductList().add(productFour);
        productSorter.getProductList().add(productFive);
        productSorter.getProductList().add(productSix);

    }

    @Test
    public void givenProductSorterObjectThenProductListInitializedAsArrayList() {
        assertThat(MESSAGE_SIX, productSorter, hasProperty("productList", instanceOf(ArrayList.class)));
        assertThat(MESSAGE_SEVEN, productSorter.getProductList(), is(empty()));
    }

    @Test
    public void givenProductListThenReturnListSortedByNameLengthAscending() {
        addTestProductData();
        List<Product> nameLengthSortedList = productSorter.sortProductByNameLength();
        System.out.println(nameLengthSortedList);
        assertThat(MESSAGE_ONE, nameLengthSortedList, contains(productTwo, productOne, productThree, productFive, productSix, productFour));
    }

    @Test
    public void givenProductListThenReturnListSortedByNameAscending() {
        addTestProductData();
        List<Product> nameSortedList = productSorter.sortProductByName();
        assertThat(MESSAGE_TWO, nameSortedList, contains(productSix, productTwo, productOne, productFive, productFour, productThree));
    }

    @Test
    public void givenProductListThenReturnListSortedByPriceDescending() {
        addTestProductData();
        List<Product> priceSortedList = productSorter.sortProductByPriceDescending();
        assertThat(MESSAGE_THREE, priceSortedList, contains(productFour, productFive, productSix, productTwo, productOne, productThree));
    }

    @Test
    public void givenProductListThenReturnListSortedByCategoryAscendingAndByPriceDescending() {
        addTestProductData();
        List<Product> categoryPriceSortedList = productSorter.sortProductByCategoryAscendingAndByPriceDescending();
        assertThat(MESSAGE_FOUR, categoryPriceSortedList, contains(productTwo, productOne, productThree, productFour, productFive, productSix));
    }

    @Test
    public void givenEmptyProductListThenReturnEmptyList() {
        List<Product> list = productSorter.sortProductByName();
        assertThat(MESSAGE_FIVE, list, is(empty()));
    }

}
