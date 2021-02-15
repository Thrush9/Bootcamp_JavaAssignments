package com.stackroute.oops;


import java.util.ArrayList;
import java.util.List;

public class ProductOrder {

    /* Define the properties as given in problem.md */
     private int id;
     private String name;
     private List<ProductLineItem> lineItems = new ArrayList<ProductLineItem>();
 
    /*
       Complete the Parameterized constructor to initialize all properties of Author
    */

    public ProductOrder(int id, String name) {
    	
    	this.id = id;
    	this.name= name;

    }

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

    public List<ProductLineItem> getLineItems() {

    	List<ProductLineItem> getItems = new ArrayList<>();
    	getItems.addAll(lineItems);
        return getItems;
        
    }

    /*Add line item to order*/
    public void addItem(int id, int quantity, Product product) {

    	ProductLineItem lineItem = new ProductLineItem(id, quantity, product);
    	lineItems.add(lineItem);
    	
    }

    /* Remove line item from order for given item id the method should return appropriate message based on itemId */

    public String removeItemById(int itemId) {

		String result = "LineItem removed successfully";

		if (itemId <= 0) {
			result = "Please pass valid itemId";
		} else {
			for (ProductLineItem item : lineItems) {
				if(item.getId() == itemId) {
					lineItems.remove(item);
				}
			}
		}
		return result;
    }
}
