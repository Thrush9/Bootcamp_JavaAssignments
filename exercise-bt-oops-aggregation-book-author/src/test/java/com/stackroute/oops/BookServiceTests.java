package com.stackroute.oops;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BookServiceTests {

    private static final String MSG_01 = "should return an author object initialized with passed values";
    private static final String MSG_02 = "should return a book object initialized with passed values";

    private BookService bookService;

    @BeforeEach
    public void setUp() {
        bookService = new BookService();
    }

    @AfterEach
    public void tearDown() {
        bookService = null;
    }

    @Test
    public void givenAuthorPropertyValuesThenAuthorObjectCreated() {
        final Author author = bookService.createAuthor("Cathy Sierra", "USA");

        assertNotNull(author, MSG_01);
        assertEquals("Cathy Sierra", author.getName(), MSG_01);
    }

    @Test
    public void givenBookPropertyValuesThenBookObjectCreated() {
        final Book book = bookService.createBook(9781234561L, "Head First Java", "Second", "Cathy Sierra", "USA");

        assertNotNull(book, MSG_02);
        assertEquals("Head First Java", book.getTitle(), MSG_02);
        assertEquals("USA", book.getAuthor().getCountry(), MSG_02);
    }
}