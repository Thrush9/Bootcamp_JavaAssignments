package com.stackroute.commonjavaclasses;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ISBNValidatorTests {
    private static final String MESSAGE_ONE = "Method should return one if the specified string follows the rule";
    private static final String MESSAGE_TWO = "Method should return zero if the specified string does not follow the rule";
    private static final String MESSAGE_THREE = "Method should return minus one for Null or Empty string";
    private static final String MESSAGE_FOUR= "Method throws exception when input string is not a proper number";

    private static final String VALID_VALUES="0201103311";
    private static final String[] INVALID_VALUES={"8965142316","8988899","77ui889789","invalid"};
    private static final String[] EMPTY_VALUES={"",null};
    private ISBNValidator isbnValidator;

    @BeforeEach
    public void setUp() {
        isbnValidator= new ISBNValidator();
    }

    @AfterEach
    public void tearDown() {
        isbnValidator = null;
    }

    @Test
    public void givenValidNumberValuesWhenCheckedThenReturnOne(){
        assertEquals(1,isbnValidator.validateISBNNumber(VALID_VALUES),MESSAGE_ONE);
    }

    @Test
    public void givenInValidNumberValuesWhenCheckedThenReturnZero(){
        assertEquals(0,isbnValidator.validateISBNNumber(INVALID_VALUES[0]),MESSAGE_TWO);
        assertEquals(0,isbnValidator.validateISBNNumber(INVALID_VALUES[1]),MESSAGE_TWO);
    }

    @Test
    public void givenEmptyValuesWhenCheckedThenReturnMinusOne(){
        assertEquals(-1,isbnValidator.validateISBNNumber(EMPTY_VALUES[0]),MESSAGE_THREE);
        assertEquals(-1,isbnValidator.validateISBNNumber(EMPTY_VALUES[0]),MESSAGE_THREE);
    }

    @Test
    public void givenInvalidStringValuesWhenCheckedThenThrowsException(){
        assertThrows(NumberFormatException.class,()->
                isbnValidator.validateISBNNumber(INVALID_VALUES[2]),MESSAGE_FOUR);
        assertThrows(NumberFormatException.class,()->
                isbnValidator.validateISBNNumber(INVALID_VALUES[3]),MESSAGE_FOUR);
    }
}
