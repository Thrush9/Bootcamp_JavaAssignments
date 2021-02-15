package com.stackroute.oops;

import com.stackroute.oops.Author;
import com.stackroute.oops.Book;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BookTests {
    public static final String ACTIVE = "active";
    private static final String MSG_01 = "check the constructor for proper initialization of properties";
    private static final String MSG_02 = "check the setters for proper assignment of property values";
    private static final String MSG_03 = "details returned by getBookDetails method is not correct or not as per required format";

    private Book book;
    private Author author;

    @BeforeEach
    public void setUp() {
        author = new Author("Cathy Sierra", "USA");
        book = new Book(9781234561L, "Head First Java", "Second", author);
    }

    @AfterEach
    public void tearDown() {
        author = null;
        book = null;
    }

    @Test
    public void givenValidPropertyValuesWhenBookObjectCreatedThenPropertiesAreSet() {
        assertEquals(9781234561L, book.getIsbn(), MSG_01);
        assertEquals("Head First Java", book.getTitle(), MSG_01);
        assertEquals("Second", book.getEdition(), MSG_01);
        assertNotNull(book.getAuthor(), MSG_01);
    }

    @Test
    public void givenBookObjectWhenPropertyValuesAreChangedBySettersThenPropertiesAreSet() {
        book.setTitle("Test title");
        book.setEdition("First");
        assertEquals("Test title", book.getTitle(), MSG_02);
        assertEquals("First", book.getEdition(), MSG_02);
    }

    @Test
    public void givenBookObjectThenGetAuthorDetails() {
        var bookDetails = book.getBookDetails();
        var expectedDetails = "Book{isbn=9781234561, title='Head First Java', edition='Second', author=Author{name='Cathy Sierra', country='USA'}}";
        final var regex = "//s+";
        assertEquals(expectedDetails.toLowerCase().replaceAll(regex, " "), bookDetails.toLowerCase().replaceAll(regex, " "), MSG_03);
    }

}