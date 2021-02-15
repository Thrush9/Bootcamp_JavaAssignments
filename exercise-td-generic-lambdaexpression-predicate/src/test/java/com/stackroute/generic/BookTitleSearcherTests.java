package com.stackroute.generic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

public class BookTitleSearcherTests {
    private static final String MESSAGE_ONE = "Given the book list and books to search should return list of all the matching books";
    private static final String MESSAGE_TWO = "Given empty string or null value for search title should return empty Optional";
    private static final String MESSAGE_THREE = "Given empty list or list with null value should return empty Optional";
    private BookTitleSearcher bookTitleSearcher;
    private List<String> booksList = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        bookTitleSearcher = new BookTitleSearcher();
    }

    @AfterEach
    public void tearDown() {
        bookTitleSearcher = null;
    }

    /*Adding books to list for test data*/
    public void addBooksToList() {
        booksList.add("Introduction to Spring framework");
        booksList.add("Spring Boot in Action");
        booksList.add("Cloud Native Java");
        booksList.add("Spring Microservices");
        booksList.add("Introducing Java EE 7");
    }

    @Test
    public void givenBookListAndSearchValueWhenMatchedThenReturnMatchedBookList() {
        addBooksToList();
        List<String> matchedList = bookTitleSearcher.getBookList(booksList, "Spring").get();
        assertThat(MESSAGE_ONE, matchedList, contains("Introduction to Spring framework", "Spring Boot in Action", "Spring Microservices"));
    }

    @Test
    public void givenBookListAndPredicateValueWhenMatchedThenReturnMatchedBookList() {
        addBooksToList();
        List<String> matchedList = bookTitleSearcher.searchBookNames(booksList, n -> n.contains("Spring")).get();
        assertThat(MESSAGE_ONE, matchedList, contains("Introduction to Spring framework", "Spring Boot in Action", "Spring Microservices"));
    }

    @Test
    public void givenBookListAndSearchValueWhenNotMatchedThenReturnEmptyBookList() {
        addBooksToList();
        List<String> matchedList = bookTitleSearcher.searchBookNames(booksList, n -> n.contains("Angular")).get();
        assertThat(MESSAGE_ONE, matchedList, is(empty()));
    }

    @Test
    public void givenBookListAndPredicateValueWhenNotMatchedThenReturnReturnEmptyBookList() {
        addBooksToList();
        List<String> matchedList = bookTitleSearcher.searchBookNames(booksList, n -> n.contains("Spring")).get();
        assertThat(MESSAGE_ONE, matchedList, contains("Introduction to Spring framework", "Spring Boot in Action", "Spring Microservices"));
    }

    @Test
    public void givenEmptyBookListAndSearchValueThenReturnEmptyOptional() {
        Optional<List<String>> matchedList = bookTitleSearcher.getBookList(booksList, "Angular");
        assertThat(MESSAGE_THREE, matchedList, is(Optional.empty()));
    }

    @Test
    public void givenEmptyBookListAndPredicateValueThenReturnEmptyOptional() {
        Optional<List<String>> matchedList = bookTitleSearcher.searchBookNames(booksList, n -> n.contains("Spring"));
        assertThat(MESSAGE_THREE, matchedList, is(Optional.empty()));
    }

    @Test
    public void givenBookListAsNullAndSearchValueThenReturnEmptyOptional() {
        Optional result= bookTitleSearcher.getBookList(null, "Angular");
        assertThat(MESSAGE_THREE,result,is(Optional.empty()));
    }

    @Test
    public void givenBookListAsNullAndPredicateValueThenReturnEmptyOptional() {
        Optional result= bookTitleSearcher.searchBookNames(null, n -> n.contains("Spring"));
        assertThat(MESSAGE_THREE,result,is(Optional.empty()));
    }

    @Test
    public void givenBookListAndEmptySearchValueThenReturnCompleteBookList() {
        addBooksToList();
        Optional<List<String>>result= bookTitleSearcher.getBookList(booksList, "");
        assertThat(MESSAGE_TWO,result,is(Optional.empty()));
    }

    @Test
    public void givenBookListAndSearchValueAsNullThenReturnCompleteBookList() {
        addBooksToList();
        Optional<List<String>> result = bookTitleSearcher.getBookList(booksList, null);
        assertThat(MESSAGE_TWO,result,is(Optional.empty()));
    }

}
