package com.stackroute.streams;

import java.util.OptionalDouble;
import java.util.stream.IntStream;

/**
 * Utility class for operations on elements of array
 */
public class NumberUtility {

	/**
	 * Returns sum of even numbers from the array Returns 0, if there are no even
	 * numbers or if the passed array is null
	 */
	public long getSumOfEven(int[] numbers) {
		long result = 0;
		if (numbers == null || numbers.length == 0)
			return result;
		else
			result = IntStream.of(numbers).filter(num -> num % 2 == 0).sum();
		return result;
	}

	/**
	 * Returns average of all the integers as optionalDouble from given array
	 * Returns Empty Optional, if the given array is null or empty
	 */
	public OptionalDouble getAverageOfOdd(int[] numbers) {
		OptionalDouble result = null;
		if (numbers == null || numbers.length == 0)
			return OptionalDouble.empty();
		else
			result = IntStream.of(numbers).filter(num -> num % 2 == 1).average();
			return result;
	}

	/**
	 * Returns product of all numbers Returns 0 if the array is null or empty
	 */
	public long getProduct(int[] numbers) {
		long result = 0;
		if (numbers == null || numbers.length == 0)
			return result;
		else
			result = IntStream.of(numbers).reduce(1,(a,b)->a*b);
		return result;
	}

}