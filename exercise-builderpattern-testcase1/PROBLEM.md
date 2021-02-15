## Problem Statement: Writing unit test cases for the given solution ##

**This exercise should be completed by writing unit test cases for the solution provided**

- Below is the summary of the solution provided
    - class `Employee` 
        - contains parameterized constructor to initialize desired properties
        - contains  static nested class `EmployeeBuilder` to add optional properties
            - Nested class contains methods to validate age and phone number properties
        - contains overridden `toString` method to display employee details
    - class `EmployeeService` 
        - contains various methods to create employee with desired and optional properties
        
- Create class `EmployeeTests` in package com.stackroute.oops and write the unit tests for testing object creation with optional and desired properties        
-   Some of the test cases are mentioned below
    - On object creation of `Employee` all desired properties should be set
    - When `EmployeeBuilder` nested class is used to create Employee object, should able to add optional properties also
    - When optional age and phone properties are added, should validate those properties
    - Employee details are displayed in the required format
    
- Create class `EmployeeServiceTests` in package com.stackroute.oops and write unit tests for testing all the methods of `EmployeeService` class.
-   Some of the test cases are mentioned below
    - `createBasicemployee` should create employee object with desired properties
    - `createEmployeeWithAge` should create employee object with desired properties and optional age property
    - `createEmployeeWithPhone` should create employee object with desired properties and optional Phone property
    - `createEmployeeWithAddress` should create employee object with desired properties and optional address property
    - `createEmployeeWithAgePhoneAndAddress` should create employee object with all desired and optional properties 

- Minimum test cases expected : 5
- Test cases should be written for positive, negative and boundary scenarios, wherever applicable
- Test coverage should be 100%
    

## Instructions
- Avoid printing unnecessary values other than expected output as given in sample
- Take care of whitespace/trailing whitespace
- Do not change the provided class/method names unless instructed
- Follow best practices while coding
