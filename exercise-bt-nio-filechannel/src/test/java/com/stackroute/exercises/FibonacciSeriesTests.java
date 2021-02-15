package com.stackroute.exercises;

import org.junit.jupiter.api.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


import static org.junit.jupiter.api.Assertions.*;

public class FibonacciSeriesTests {

    private FibonacciSeries fibonacciSeries;
    private FileOutputStream fileOutputStream;
    private String firstFile = "FibonacciSeries.txt";
    private String message = "Check the logic in method fileContentAdder";
    private String expectedErrorMessage = "Given fileName to read or write is empty, null or blank space";

    @BeforeEach
    public void setUp() throws IOException {
        fibonacciSeries = new FibonacciSeries();
        fileOutputStream = new FileOutputStream(firstFile);
        fileOutputStream.write("".getBytes());
    }

    @AfterEach
    public void tearDown() throws IOException {
        fibonacciSeries = null;
        fileOutputStream.close();
    }

    @Test
    public void givenAStringAndPositiveIntegerThenReturnAStringResult() throws IOException {
        assertEquals(fibonacciSeries.fileContentAdder(firstFile, 37), new String(new FileInputStream(firstFile).readAllBytes()), "Check the Logic in methods fileContentAdder, fibonacciSeriesGenerator, fibonacciCalculator");
    }

    @Test
    public void givenANonAlphanumericStringAndPositiveIntegerThenReturnAnErrorString() throws IOException {
        assertEquals("File with ./ not found", fibonacciSeries.fileContentAdder("./", 10), "Check the Logic in method fileContentAdder, should handle FileNotFoundException");
        assertEquals("File with src/ not found", fibonacciSeries.fileContentAdder("src/", 23), "Check the Logic in method fileContentAdder, should handle FileNotFoundException");
    }

    @Test
    public void givenAStringAndNegativeIntegerThenReturnAnErrorString() throws IOException {
        assertEquals("The length of series should be between 1 and 40", fibonacciSeries.fileContentAdder(firstFile, -10), "Method fileContentAdder should return error message when series length is negative");
        assertEquals("The length of series should be between 1 and 40", fibonacciSeries.fileContentAdder(firstFile, 41), "Method fileContentAdder should return error message when series length is negative");
    }

    @Test
    public void givenEmptyFileNameStringThenReturnAnErrorString() throws IOException {
        assertEquals(expectedErrorMessage, fibonacciSeries.fileContentAdder("", 20), message);
    }

    @Test
    public void givenBlankSpaceFileNameThenReturnAnErrorString() throws IOException {
        assertEquals(expectedErrorMessage, fibonacciSeries.fileContentAdder(" ", 40), message);
    }

    @Test
    public void givenNullFileNameThenReturnAnErrorString() throws IOException {
        assertEquals(expectedErrorMessage, fibonacciSeries.fileContentAdder(null, 10), message);
    }

}
