package com.stackroute.lamdbaexpression;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ConsumerFunctionalInterface {

	// write logic to find the square of each number in a given list of numbers
	public List<BigInteger> findSquare(List<BigInteger> list) {
		List<BigInteger> result = new ArrayList<>();
		Consumer<BigInteger> squareList = num -> result.add(num.multiply(num));
		if (list != null) {
			for (BigInteger bigNum : list) {
				squareList.accept(bigNum);
			}	
		}
		return result;
	}
}
