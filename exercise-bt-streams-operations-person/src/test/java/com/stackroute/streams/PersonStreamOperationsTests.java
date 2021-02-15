package com.stackroute.streams;

import com.stackroute.streams.PersonStreamOperations;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonStreamOperationsTests {
    private static final String MESSAGE_ONE = "Should return list of person names in ascending order in upper case";
    private static final String MESSAGE_TWO = "Should return person found if the person exists in the list";
    private static final String MESSAGE_THREE = "Should return an array of distinct person names sorted in descending order";
    private static final String MESSAGE_FOUR = "Should return empty optional if the list is null or empty";
    private static final String MESSAGE_FIVE = "Should return empty set or list  when list is null or empty";
    private static final String MESSAGE_SIX = "Should return names having length greater than five sorted by length";
    private static final String MESSAGE_SEVEN = "Should return the person name having maximum age";
    private static final String MESSAGE_EIGHT = "Should return null when map is null or empty";

    private PersonStreamOperations personStreamOperations;
    private List<String> personList;
    private List<String> emptyList;

    @BeforeEach
    public void setUp() {
        personStreamOperations = new PersonStreamOperations();
        personList = List.of("Kamala", "Kamala", "Priyanka", "Gautham", "Moses", "Joseph", "Anil", "Prashanth");
        emptyList = Collections.emptyList();
    }

    @AfterEach
    public void tearDown() {
        personStreamOperations = null;
    }

    @Test
    public void givenPersonListThenReturnListInAlphabeticalOrderInUppercase() {
        Optional<List<String>> sortedPersonList = Optional.of(List.of("ANIL", "GAUTHAM", "JOSEPH", "KAMALA", "KAMALA", "MOSES", "PRASHANTH", "PRIYANKA"));
        assertEquals(sortedPersonList, personStreamOperations.getPersonListSortedByNameInUpperCase(personList), MESSAGE_ONE);
    }

    @Test
    public void givenPersonListWithEmptyValuesThenReturnListInAlphabeticalOrderInUppercase() {
        personList = List.of("Kamala", "Kamala", "Priyanka", "Gautham", "Moses", "Joseph", "Anil", "Prashanth", "", " ");
        Optional<List<String>> sortedPersonList = Optional.of(List.of("ANIL", "GAUTHAM", "JOSEPH", "KAMALA", "KAMALA", "MOSES", "PRASHANTH", "PRIYANKA"));
        assertEquals(sortedPersonList, personStreamOperations.getPersonListSortedByNameInUpperCase(personList), MESSAGE_ONE);
    }

    @Test
    public void givenEmptyPersonListThenReturnEmptyOptional() {
        assertThat(MESSAGE_FOUR, personStreamOperations.getPersonListSortedByNameInUpperCase(null), is(Optional.empty()));
    }

    @Test
    public void givenNullPersonListThenReturnEmptyOptional() {

        assertThat(MESSAGE_FOUR, personStreamOperations.getPersonListSortedByNameInUpperCase(emptyList), is(Optional.empty()));
    }

    @Test
    public void givenPersonListWhenSearchedNamePresentThenReturnFound() {
        assertEquals("Person found", personStreamOperations.searchPerson(personList, "Gautham"), MESSAGE_TWO);
    }

    @Test
    public void givenPersonListWhenSearchedNameNotPresentThenReturnNotFound() {
        assertEquals("Person not found", personStreamOperations.searchPerson(personList, "Kavya"), MESSAGE_TWO);
    }

    @Test
    public void givenPersonListWhenSearchedNamePresentWithNonMatchingCaseThenReturnFound() {
        assertEquals("Person found", personStreamOperations.searchPerson(personList, "GAUTHAM"), MESSAGE_TWO);
    }

    @Test
    public void givenPersonListAsNullOrSearchNameNullThenReturnFalse() {
        assertEquals("Give proper input not null", personStreamOperations.searchPerson(personList, null), MESSAGE_TWO);
        assertEquals("Give proper input not null", personStreamOperations.searchPerson(null, "Kavya"), MESSAGE_TWO);
    }

    @Test
    public void givenPersonListThenReturnDistinctPersonNamesInDescendingOrder() {
        personList = List.of("Kamala", "Kamala", "Joseph", "Gautham", "Priyanka", "Moses", "Anil", "Prashanth");
        assertThat(MESSAGE_THREE, personStreamOperations.getDistinctPersonNamesSortedInDescendingOrder(personList), contains("Priyanka", "Prashanth", "Moses", "Kamala", "Joseph", "Gautham", "Anil"));
    }

    @Test
    public void givenPersonListWithEmptyValuesThenReturnDistinctPersonNamesInDescendingOrder() {
        personList = List.of("Kamala", "Kamala", "Joseph", "Gautham", "Priyanka", "Moses", "Anil", "Prashanth", "", "  ");
        assertThat(MESSAGE_THREE, personStreamOperations.getDistinctPersonNamesSortedInDescendingOrder(personList), contains("Priyanka", "Prashanth", "Moses", "Kamala", "Joseph", "Gautham", "Anil"));
    }

    @Test
    public void givenPersonListAsEmptyOrNullThenReturnEmptySet() {
        assertThat(MESSAGE_FIVE, personStreamOperations.getDistinctPersonNamesSortedInDescendingOrder(emptyList), is(Collections.emptySet()));
        assertThat(MESSAGE_FIVE, personStreamOperations.getDistinctPersonNamesSortedInDescendingOrder(null), is(Collections.emptySet()));
    }

    @Test
    public void givenPersonListThenReturnSortedNameListByLengthGreaterThanFive() {
        List<String> sortedList = List.of("Kamala", "Kamala", "Joseph", "Gautham", "Priyanka", "Prashanth");
        assertEquals(sortedList, personStreamOperations.getPersonListSortedByLengthWithNameLengthGreaterThanFive(personList), MESSAGE_SIX);
    }

    @Test
    public void givenPersonListWithEmptyValuesThenReturnSortedNameListByLengthGreaterThanFive() {
        List<String> sortedList = List.of("Kamala", "Kamala", "Joseph", "Gautham", "Priyanka", "Prashanth");
        personList = List.of("Kamala", "Kamala", "Priyanka", "Gautham", "Moses", "Joseph", "Anil", "Prashanth", "", " ");
        assertEquals(sortedList, personStreamOperations.getPersonListSortedByLengthWithNameLengthGreaterThanFive(personList), MESSAGE_SIX);
    }

    @Test
    public void givenPersonListAsNullOrEmptyThenReturnEmptyList() {
        assertThat(MESSAGE_FIVE, personStreamOperations.getPersonListSortedByLengthWithNameLengthGreaterThanFive(emptyList), is(Collections.emptyList()));
        assertThat(MESSAGE_FIVE, personStreamOperations.getPersonListSortedByLengthWithNameLengthGreaterThanFive(null), is(Collections.emptyList()));
    }

    @Test
    public void givenPersonAgeMapThenReturnPersonWithMaxAge() {
        Map<String, Integer> personMap = Map.of("Gautham", 30, "Latha", 56, "Punith", 45);
        assertEquals("Latha", personStreamOperations.getPersonByMaxAge(personMap), MESSAGE_SEVEN);
    }

    @Test
    public void givenPersonAgeMapAsNullOrEmptyThenReturnNull() {
        Map<String, Integer> personMap = new HashMap<>();
        assertEquals("Give proper input not null", personStreamOperations.getPersonByMaxAge(personMap), MESSAGE_EIGHT);
        assertEquals("Give proper input not null", personStreamOperations.getPersonByMaxAge(null), MESSAGE_EIGHT);
    }
}
