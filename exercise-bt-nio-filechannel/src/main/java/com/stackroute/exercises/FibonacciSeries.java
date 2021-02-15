package com.stackroute.exercises;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class FibonacciSeries {

	// write here logic to write a string from fibonacciSeriesGenerator in a file
	public String fileContentAdder(String fileName, int seriesLength) throws IOException {
		String result = "check";
		String invalidFile = "Given fileName to read or write is empty, null or blank space";
		String invalidInt = "The length of series should be between 1 and 40";
		if (fileName == null || fileName == " " || fileName == "")
			return invalidFile;
		else if (seriesLength < 1 || seriesLength > 40)
			return invalidInt;
		else {
			try {
				FileWriter fwriter = new FileWriter(fileName);
				BufferedWriter bwriter = new BufferedWriter(fwriter);
				bwriter.write(fibonacciSeriesGenerator(seriesLength));
				bwriter.close();
				result = fibonacciSeriesGenerator(seriesLength);
			} catch (FileNotFoundException e) {
				result = "File with " + fileName + " not found";
				return result;
			}
		}
		return result;
	}

	// Write here logic to create the series of fibonacci numbers returned by
	// fibonacciCalculator
	public String fibonacciSeriesGenerator(int seriesLength) {

		String result = "";
		for (int i = 0; i <= seriesLength; i++) {
			result = result + " " + fibonacciCalculator(i);
		}
		return result;
	}

	// Write here logic here to find fibonacci number at particular position in the
	// series
	public int fibonacciCalculator(int num) {
		int a = 0, b = 1, c;
		if (num == 0)
			return a;
		else if (num == 1)
			return b;
		for (int i = 2; i <= num; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		return b;
	}
}


