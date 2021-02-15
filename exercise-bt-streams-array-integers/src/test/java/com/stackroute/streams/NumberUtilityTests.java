package com.stackroute.streams;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.OptionalDouble;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class NumberUtilityTests {

    private static final String MSG_01 = "output doesn't match the expected result. check the method logic";
    private static final String MSG_02 = "should return 0 for null or empty input array";
    private static final String MSG_03 = "should return empty OptionalDouble";

    private NumberUtility numberUtility;

    /**
     * Below static methods are the test data for parameterized Tests
     */
    private static Stream<Arguments> testDataForSumOfEven() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, 12),
                Arguments.of(new int[]{1, 3, 5}, 0)
        );
    }

    private static Stream<Arguments> testDataForAverageOfOdd() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, OptionalDouble.of(3.0)),
                Arguments.of(new int[]{2, 4, 6}, OptionalDouble.empty()),
                Arguments.of(new int[]{5, 5, 3, 3}, OptionalDouble.of(4.0))
        );
    }

    private static Stream<Arguments> testDataForProduct() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, 6L),
                Arguments.of(new int[]{2, 4, 0}, 0L),
                Arguments.of(new int[]{-1, -2, -3}, -6L)
        );
    }

    @BeforeEach
    public void setUp() {
        numberUtility = new NumberUtility();
    }

    @AfterEach
    public void tearDown() {
        numberUtility = null;
    }

    @ParameterizedTest(name = "input {0} : sum of even numbers = {1}")
    @MethodSource("testDataForSumOfEven")
    public void givenArrayOfIntThenGetSumOfEvenNumbers(int[] numbers, long expected) {
        assertThat(MSG_01, numberUtility.getSumOfEven(numbers), is(expected));
    }

    @ParameterizedTest(name = "when input is {0}, return 0")
    @NullAndEmptySource
    public void givenEmptyOrNullArrayThenReturnZero(int[] numbers) {
        assertThat(MSG_02, numberUtility.getSumOfEven(numbers), is(0L));
    }

    @ParameterizedTest(name = "input {0} : average of odd numbers = {1}")
    @MethodSource("testDataForAverageOfOdd")
    public void givenArrayOfIntThenGetAverageOfOddNumbers(int[] numbers, OptionalDouble expected) {
        assertThat(MSG_01, numberUtility.getAverageOfOdd(numbers), is(expected));
    }

    @ParameterizedTest(name = "when input is {0}, return empty OptionalDouble")
    @NullAndEmptySource
    public void givenEmptyOrNullArrayThenReturnEmptyOptional(int[] numbers) {
        assertThat(MSG_03, numberUtility.getAverageOfOdd(numbers), is(OptionalDouble.empty()));
    }

    @ParameterizedTest(name = "input {0} : average of odd numbers = {1}")
    @MethodSource("testDataForProduct")
    public void givenArrayOfIntThenReturnProductOfNumbers(int[] numbers, long expected) {
        assertThat(MSG_01, numberUtility.getProduct(numbers), is(expected));
    }

    @ParameterizedTest(name = "when input is {0}, return 0")
    @NullAndEmptySource
    public void givenEmptyOrNullArrayThenReturnProductAsZero(int[] numbers) {
        assertThat(MSG_02, numberUtility.getProduct(numbers), is(0l));
    }
}