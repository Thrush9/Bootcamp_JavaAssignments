package com.stackroute.exercises;

import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class FractionTests {

    private Fraction fraction;
    private String message = "Check the logic in method fractionCalculator";

    @BeforeEach
    public void setUp() {
        fraction = new Fraction();
    }

    @AfterEach
    public void tearDown() {
        fraction = null;
    }

    @Test
    public void givenTwoIntegersWhenDividedThenReturnAStringResult() {
        assertEquals("12", fraction.fractionCalculator(24, 2), message);
    }

    @Test
    public void givenTwoIntegersOneZeroWhenDividedThenReturnAErrorString() {
        assertEquals("java.lang.ArithmeticException: / by zero", fraction.fractionCalculator(20, 0), "Use try catch to handle the exception");
    }

    @Test
    public void givenTwoNegativeIntegersWhenDividedThenReturnAStringResult() {
        assertEquals("43", fraction.fractionCalculator(-129, -3), message);
    }

    @Test
    public void givenTwoIntegersOneNegativeWhenDividedThenReturnAStringResult() {
        assertEquals("-11", fraction.fractionCalculator(440, -40), message);
    }
}
