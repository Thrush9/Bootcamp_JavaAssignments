package com.stackroute.oops;

public class ProductLineItem {

    /* Define the properties as given in problem.md */
       
	   private int id;
	   private int quantity;
	   private Product prod;

    /*
       Complete the Parameterized constructor to initialize all properties of Author
    */

    public ProductLineItem(int id, int quantity, Product product) {
    	
    	this.id = id;
    	this.quantity = quantity;
    	this.prod = product;

    }


    /*
        Complete the Getters and Setters
    */
    public int getId() {

        return id;
        
    }

    public void setId(int id) {

        this.id = id;
    	
    }

    public int getQuantity() {

        return quantity;
    }

    public void setQuantity(int quantity) {

        this.quantity = quantity;
    	
    }

    public Product getProduct() {

        return prod;
        
    }

    public void setProduct(Product product) {

    	this.prod = product;

    }

    /*
        This method should return a string containing the ProductLineItem details in below format
            ProductLineItem{id=xx,quantity='xxxxx', description='xxxx',Product{id=x, name='xxx', description='xxxxx'}}
     */
    public String getItemDetails() {
        return "ProductLineItem{id="+ getId() + ",quantity=" + getQuantity() + ",Product=Product{id="+ prod.getId() + 
        		", name='" + prod.getName() + "', description='" + prod.getDescription() + "'}}";
    }
}
