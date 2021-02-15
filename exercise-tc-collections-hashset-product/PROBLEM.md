## Problem Statement: Writing unit test cases for the given solution ##

**This exercise should be completed by writing unit test cases for the solution provided**

- Below is the summary of the solution provided
    - class `Product` 
        - contains parameterized constructor to initialize all properties
        - contains overridden `toString` method to display product details
        - contains overridden `equals` and `hashcode`
        - contains overridden `compareTo` which compares object based on price property
    - class `InvalidPriceException` 
        - contains constructor for this user defined exception
    - class `ProductSetService`
        - contains various methods to add, search, remove and list products for the product set.

- Create class `ProductTests` in package com.stackroute.collections
    - Should check the creation of product with all properties set properly
    - Should check Product is of Comparable type
    - Minimum test cases expected : 4
    
- Create class `ProductSetServiceTests` in package com.stackroute.collections 
    - `addProductToSet` should add a new product to set
    - `replaceProductName` should replace the product with new name if it exists in the set
    - `getProductWithHigherPrice` Should return product with highest price 
    - `removeProductWithPriceHigherThanFiveThousand` should remove the product matching the criteria
    - `getProductIdList` should return the list of product ID 
    -  Minimum test cases expected: 10

- Test cases should be written for positive, negative and boundary scenarios, wherever applicable
- Test coverage should be 100%       

## Instructions
- Avoid printing unnecessary values other than expected output as given in sample
- Take care of whitespace/trailing whitespace
- Do not change the provided class/method names unless instructed
- Follow best practices while coding
