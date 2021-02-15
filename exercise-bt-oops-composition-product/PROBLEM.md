## Problem Statement: Implementing Composition

Composition is an association that represents a part of a whole relationship where a part cannot exist without a whole.

-Important points

    -Composition represents a part-of the whole relationship.
    -Both the entities are dependent on each other in composition.
    -When there is a composition between two entities, the composed object cannot exist without the other entity. 
    -Favor Composition over Inheritance.


For example, if order HAS-A line-items, then an order is a whole and line items are parts. 
If an order is deleted then all corresponding line items for that order should be deleted.

Complete the class Product, ProductLineItem and ProductOrder as per the below requirement

**class Product**

Define the following properties. properties should be private:

        -id          : int 
        -name        : String 
        -description : String

- Define parameterized constructor to initialize all the properties. 

- Define Getters and Setters for all properties 
     
- Define the below methods:

        +getProductDetails() : String               
          -Should return the product details as per the below format
            Product{name='xxxxx', description='xxxx'}

**Class ProductLineItem**

Define the following properties. properties should be private:

        -id        : int         
        -quantity  : int
        -product   : Product
         

- Define parameterized constructor to initialize all the properties

- Define Getters and Setters for all properties 
     
- Define the below methods:

        +getItemDetails() : String             
          -Should return the Item details as per the below format
        ProductLineItem{id=xxxxxxxx, quantity='xxxxxxxx',  product=Product{id='xxxx',name='xxxxx', description='xxxx'}}


**class ProductOrder**

-Define the following properties. properties should be private:

        -id        : int         
        -name      : int
        -lineItems : List<ProductLineItem>
        

- Define parameterized constructor to initialize 2 of the properties id and name
    initialize the list of lineItems in the constructor without any line items added

- Define Getters and Setters for all properties 
     
- Define the below methods:

        +getLineItems() : List<ProductLineItem>        
            -should return the list of productLineItems
      
        +addItem : void
            -returns nothing.
            -adds line item to the order
        
        +removeItemById(itemId:int) : String
            -takes in one integer parameter
            -should return appropriate message based on the itemId
            -removes line item from order
            
       
     
## Instructions
- Do not change the provided class/method names unless instructed
- Ensure your code compiles without any errors/warning/deprecations 
- Follow best practices while coding