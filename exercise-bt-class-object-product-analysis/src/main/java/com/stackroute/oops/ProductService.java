package com.stackroute.oops;

import java.util.ArrayList;
import java.util.List;

/*
    Class for Analyzing the products present in ProductRepository
 */
public class ProductService {

	/*
	 * Returns the name of the product given the productCode
	 */
	public String findProductNameByCode(int productCode) {

		String result = null;
		Product[] prodList = ProductRepository.getProducts();
		for (Product product : prodList) {
			if (product.getProductCode() == productCode) {
				result = product.getName();
			}
		}
		return result;

	}

	/*
	 * Returns the Product with maximum price in a given category
	 */
	public Product findMaxPriceProductInCategory(String category) {
		Product result = null;
		Product[] categoryprodList = this.getProductsByCategory(category);
		if (categoryprodList != null) {
			double max = categoryprodList[0].getPrice();
			for (Product product : categoryprodList) {
				if (max < product.getPrice()) {
					max = product.getPrice();
					result = product;
				}
			}
		}
		return result;
	}

	/*
	 * Returns a array of products for a given category
	 */
	public Product[] getProductsByCategory(String category) {

		Product[] result = null;
		Product[] prodList = ProductRepository.getProducts();
		List<Product> cateogeryProd = new ArrayList<Product>();
		for (Product product : prodList) {
			if (product.getCategory().toLowerCase().equals(category.toLowerCase())) {
				cateogeryProd.add(product);
			}
		}
		if (!cateogeryProd.isEmpty()) {
			result = new Product[cateogeryProd.size()];
			result = cateogeryProd.toArray(result);
		}
		return result;
	}

}
