## Problem Statement: Implementing Aggregation

Complete the class Author, Book and BookService as per the below requirement

Aggregation represents a HAS-A relationship between two classes, and is a form of association. 
For example, the relation between class Car, MusicSystem and Tyre. Car HAS-A Tyre, Car HAS-A MusicSystem 
Aggregation occurs, when an object is made up of multiple objects. To implement aggregation for the above example, the Car class 
will have a instance variable of type MusicSystem.

**class Author**

Define the following properties. properties should be private:
        
        -name    : String 
        -country : String

- Define parameterized constructor to initialize all the properties. 

- Define Getters and Setters for all properties 
     
- Define the below methods:

        +getAuthorDetails() : String       
          - Should return the author details as per the below format

            Author{name='xxxxx', country='xxxx'}

**Class Book**

Define the following properties. properties should be private:

        -isbn      : long         
        -title     : String
        -edition   : String
        -author    : Author 

- Define parameterized constructor to initialize all the properties

- Define Getters and Setters for all properties 
     
- Define the below methods:

        +getBookDetails() : String       
          - Should return the book details as per the below format

        Book{isbn=xxxxxxxx, title='xxxxxxxx', edition='xxxxxx', author=Author{name='xxxxxx', country='xxxxxx'}}


**class BookService**
- Define the below methods:

        +createAuthor(String, String) : Author       
            - Should create an Author object using the input name and country and return the author object 

        +createBook(long, String, String, String, String) : Book
            - Should create a Book object with the below input to the method
               book details     :  isbn, title and edition 
               author details   :  name and country  
            - parameter order of inputs to the method should be as given above

## Instructions
- Do not change the provided class/method names unless instructed
- Ensure your code compiles without any errors/warning/deprecations 
- Follow best practices while coding