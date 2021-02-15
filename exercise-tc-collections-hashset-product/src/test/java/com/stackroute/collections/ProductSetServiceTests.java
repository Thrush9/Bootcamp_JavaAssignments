package com.stackroute.collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductSetServiceTests {

	private static final String MSG_01 = "check the constructor for proper initialization of properties";
	private static final String MSG_02 = "check the Productset,after adding product to set";
	private static final String MSG_03 = "initialzing with negative price should throw InvalidPriceException";
	private static final String MSG_04 = "get the set to check if the products are properly added to the productSet";
	private static final String MSG_05 = "get sorted productId from productSet in Descending Order";
	private static final String MSG_06 = "actions are posssible,only when productService exist";
	private static final String MSG_07 = "should return empty arrayList,if no products in productSet";
	private static final String MSG_08 = "get the product with Highest price from productSet";
	private static final String MSG_09 = "should return null value,if no products in productSet";
	private static final String MSG_10 = "should return productSet with all product price less than Five Thousand";
	private static final String MSG_11 = "should return same productSet, if there are no product price less than Five Thousand";
	private static final String MSG_12 = "should return replaced product, if replacemet occurs";
	private static final String MSG_13 = "should return null, if there is not product with searched name in productSet";
	
	private Product productOne;
	private Product productTwo;
	private ProductSetService productService;
	private Set<Product> productSet;

	@BeforeEach
	public void setUp() throws InvalidPriceException {
		productOne = new Product(101, "Table", 1000.00);
		productTwo = new Product(102, "Chair", 500.00);
		productSet = new HashSet<>();
		productService = new ProductSetService();
	}

	@AfterEach
	public void tearDown() {
		productOne = null;
		productTwo = null;
		productService = null;
	}

	@Test
	public void givenValidConstructorValuesForProduct() {
		assertEquals(0, productService.getProductSet().size(), MSG_01);
	}

	@Test
	public void givenProductServiceObjectThenAddProducts() throws InvalidPriceException {
		Boolean output = productService.addProductToSet(105, "Sofa", 1500.00);
		assertEquals(true, output, MSG_02);
	}
	
	@Test
	public void checkAddProductsToProductServicewithNegativePrice() throws InvalidPriceException {
		assertThrows(InvalidPriceException.class, () -> productService.addProductToSet(101,"Test Skill",-900), MSG_03);
	}
		
	@Test
	public void givenProductServiceObjectThenAddProductsToCheckForSameExists() throws InvalidPriceException {
		 productService.addProductToSet(105, "Glasses", 300.00);
		 productService.addProductToSet(105, "Plates", 500.00);
		 Set<Product> set = productService.getProductSet();
		assertEquals(set.toString(), productService.getProductSet().toString(),MSG_04);

	}
	
	@Test
	public void getProductIdListInDescendingOrderForGivenProductSerciseObject() {
		List<Integer> productId = new ArrayList<>();
		productId.add(productTwo.getProductId());
		productId.add(productOne.getProductId());
		Set<Product> set = productService.getProductSet();
		set.add(productOne);
		set.add(productTwo);
		assertEquals(productId.toString(), productService.getProductIdList().toString(),MSG_05);
	}
	
	@Test
	public void getProductIdListInDescendingOrderForGivenProductSerciseObjectFailure() {
		List<Integer> productId = new ArrayList<>();
		assertEquals(productId, productService.getProductIdList(),MSG_07);
	}
		
	@Test
	public void getProductWithHighestPriceFromProductServiceObject() {
		Set<Product> set = productService.getProductSet();
		set.add(productOne);
		set.add(productTwo);
		assertEquals(productOne.toString(), productService.getProductWithHighestPrice().toString(),MSG_08);
	}
	
	@Test
	public void getProductWithHighestPriceFromProductServiceObjectFailure() {
		assertEquals(null, productService.getProductWithHighestPrice(),MSG_09);
	}
	
	@Test
	public void removeProductWithPriceFiveThousandFromProductServiceObject() throws InvalidPriceException {
		 productService.addProductToSet(115, "Glasses", 3000.00);
		 productService.addProductToSet(125, "Sofaset", 5500.00);
		 Set<Product> set = new HashSet<>();
		 set.add(new Product(115, "Glasses", 3000.00));
		 assertEquals(set, productService.removeProductWithPriceHigherThanFiveThousand(),MSG_10);
	} 

	@Test
	public void removeProductWithPriceFiveThousandFromProductServiceObjectFailure() throws InvalidPriceException {
		 productService.addProductToSet(115, "Glasses", 300.00);
		 productService.addProductToSet(125, "Dinnerset", 1500.00);
		 Set<Product> set = new HashSet<>();
		 set.add(new Product(115, "Glasses", 300.00));
		 set.add(new Product(125, "Dinnerset", 1500.00));
		 assertEquals(set, productService.removeProductWithPriceHigherThanFiveThousand(),MSG_11);
	}
	
	@Test
	public void replaceProductNameFromProductServiceObject() throws InvalidPriceException {
		Set<Product> set = productService.getProductSet();
		set.add(productOne);
		set.add(productTwo);
		Product test = new Product(102, "Test", 500.0);
		assertEquals(test, productService.replaceProductName("Chair","Test"),MSG_12);
	}
	
	@Test
	public void replaceProductNameFromProductServiceObjectFailure() throws InvalidPriceException {
		Set<Product> set = productService.getProductSet();
		set.add(productOne);
		set.add(productTwo);
		Product test = new Product(102, "Test", 500.0);
		assertEquals(null, productService.replaceProductName("Jaguar","Test"),MSG_13);
	}
}
