package com.stackroute.lambdaexpression;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProductSorter {

	private List<Product> productList;

	public ProductSorter() {
		productList = new ArrayList<>();
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public List<Product> sortProductByNameLength() {
		Comparator<Product> compByLength = (prd, prd1) -> {
			if (prd.getName().length() - prd1.getName().length() == 0)
				return prd.getName().compareTo(prd1.getName());
			else if (prd.getName().length() - prd1.getName().length() > 0)
				return 1;
			else
				return -1;
		};
		List<Product> sortedList = productList.stream().sorted(compByLength).collect(Collectors.toList());
		return sortedList;
	}

	public List<Product> sortProductByName() {
		List<Product> sortedList = productList.stream().sorted(Comparator.comparing(Product::getName))
				.collect(Collectors.toList());
		return sortedList;
	}

	public List<Product> sortProductByPriceDescending() {
		List<Product> sortedList = productList.stream().sorted(Comparator.comparing(Product::getPrice).reversed())
				.collect(Collectors.toList());
		return sortedList;
	}

	public List<Product> sortProductByCategoryAscendingAndByPriceDescending() {
		List<Product> sortedList = productList.stream()
				.sorted(Comparator.comparing(Product::getCategory)
						.thenComparing(Comparator.comparing(Product::getPrice).reversed()))
				.collect(Collectors.toList());
		return sortedList;
	}

}
