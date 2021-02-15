package com.stackroute.exercises;


public class Fraction {
    //Write logic to calculate the fraction and return as a String
    public String fractionCalculator(int firstNumber, int secondNumber) {
    	int a,b,c;
		String result = null;
    	try {
			a = firstNumber;
            b = secondNumber;
			c = a/b ;
			result = String.valueOf(c);
		} catch (ArithmeticException e) {
			result ="java.lang.ArithmeticException: / by zero";
			return result;
		}
		return result;
    }
}
