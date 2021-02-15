package com.stackroute.oops;


public class Product {

    /* Define the properties as given in problem.md */
     private int id;
     private String name;
     private String description;

    /*
       Complete the Parameterized constructor to initialize all properties of Author
    */

    public Product(int id, String name, String description) {

    	this.id = id;
    	this.name = name;
    	this.description = description;
    	
    }

      /*
         complete the Getters and Setters
      */

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    	
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    	
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    	
    }

    /*
        This method should return a string containing the product details in below format
            product{id=xx,name='xxxxx', description='xxxx'}
     */
    public String getProductDetails() {
        return "product{id=" + getId() + ", name='" + getName() + "', description='" + getDescription() + "'}";
    }

}
