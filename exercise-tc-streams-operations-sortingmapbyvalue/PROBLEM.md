## Problem Statement: Writing unit test cases for the given solution ##

**This exercise should be completed by writing unit test cases for the solution provided**


- Below is the summary of the solution provided

- This exercise contains a class named SortingMapByValue with the following method :

           +sortByVlue(Map items,String order)
            -Should sort the map based on the order mentioned and return the map
            
- Create class SortingMapByValueTests in package com.stackroute.streams 
 
    - write the unit tests for testing sorting of map by value

- Some of the test cases are mentioned below

    - sortByValue method called with map and 'ascending' order
    - sortByValue method called with map and 'descending' order
    - sortByValue method called with map and 'any' order
    - sortByValue method called with empty map and empty order
    - sortByValue method called with null map and null order
    - sortByValue method called with 'other' order
    - sortByValue method called with map having similar values


- Minimum test cases expected : 9


- Test cases should be written for positive, negative and boundary scenarios, wherever applicable


- Test coverage should be 100%



## Instructions

- Avoid printing unnecessary values other than expected output as given in sample
- Take care of whitespace/trailing whitespace
- Do not change the provided class/method names unless instructed
- Follow best practices while coding

## Code coverage 

 - Run mvn test, the JaCoCo code coverage report will be generated at target/site/jacoco/*
 - Open the target/site/jacoco/index.html file, review the code coverage report 
 
            - Green – Code is tested or covered.
            - Red – Code is not tested or covered.
            - Yellow – Code is partially tested or covered.
 - Make sure lines coverage must meet the minimum 90%
