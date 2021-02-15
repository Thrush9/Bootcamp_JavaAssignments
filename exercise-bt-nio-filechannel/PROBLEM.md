## Problem Statement: Generate Fibonacci Series of particular range and write it in a file using Java NIO

**Given a file name and length of the series to be generated(series length between 1 and 40 only should be accepted). Generate and write it a file using Java NIO**

**This exercise contains a class named FibonacciSeries with the following methods:**

     +fileContentAdder(String, int) : String  
         - Should take one String and int as input and return a String as result
         - Should check whether the input int is between 1 and 40     
         - Should validate the input String by checking whether it is null or empty   
         - Should return an Error String when the file is empty or blank space       
         - Should handle FileNotFoundException by returning an error String     
         - Should create a Channel for the fileName and Buffer to that channel which is used to write the series to the file
         - Should pass the seriesLength to fibonacciSeriesGenerator and put the return value inside buffer            
--------------------------------------------------------
     +fibonacciSeriesGenerator(int) : String 
         - Should take an int as input and return a String as result
         - Should append the return int value from fibonacciCalculator to create a series    
--------------------------------------------------------
     +fibonacciCalculator(int) : int 
         - Should take an int as input and return a int as result
         - Should calculate the fibonacci number based on the given position in the series     


## Example
    Sample Input:
    FibonacciSeries.txt, 10     
    
    Expected Output:
    Fibonacci Series of 10 numbers: 0 1 1 2 3 5 8 13 21 34
--------------------------------------------------------
    Sample Input:
    FibonacciSeries.txt, -10
        
    Expected Output:
    The length of series should be between 1 and 40
--------------------------------------------------------
    Sample Input:
    FibonacciSeries.txt, 44
        
    Expected Output:
    The length of series should be between 1 and 40
--------------------------------------------------------
    Sample Input:
    null, 20
        
    Expected Output:
    Given fileName to read or write is empty, null or blank space


## Instructions

- Avoid printing unnecessary values other than expected output as given in sample
- Take care of whitespace/trailing whitespace
- Do not change the provided class/method names unless instructed
- Follow best practices while coding