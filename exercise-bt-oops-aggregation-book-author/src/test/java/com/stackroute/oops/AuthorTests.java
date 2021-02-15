package com.stackroute.oops;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AuthorTests {

    private static final String MSG_01 = "check the constructor for proper initialization of properties";
    private static final String MSG_02 = "check the setters for proper assignment of property values";
    private static final String MSG_03 = "details returned by getAuthorDetails method is not correct or not as per required format";

    private Author author;

    @BeforeEach
    public void setUp() {
        author = new Author("Cathy Sierra", "USA");
    }

    @AfterEach
    public void tearDown() {
        author = null;
    }

    @Test
    public void givenValidPropertyValuesWhenAuthorObjectCreatedThenPropertiesAreSet() {
        assertEquals("Cathy Sierra", author.getName(), MSG_01);
        assertEquals("USA", author.getCountry(), MSG_01);
    }

    @Test
    public void givenAuthorObjectWhenPropertyValuesAreChangedBySettersThenPropertiesAreSet() {
        author.setName("Berty Bates");
        author.setCountry("usa");
        assertEquals("Berty Bates", author.getName(), MSG_02);
        assertEquals("usa", author.getCountry(), MSG_02);
    }

    @Test
    public void givenAuthorObjectThenGetAuthorDetails() {
        var authorDetails = author.getAuthorDetails();
        var expectedDetails = "Author{name='Cathy Sierra', country='USA'}";
        final var regex = "//s+";
        assertEquals(expectedDetails.toLowerCase().replaceAll(regex, " "), authorDetails.toLowerCase().replaceAll(regex, " "), MSG_03);
    }
}