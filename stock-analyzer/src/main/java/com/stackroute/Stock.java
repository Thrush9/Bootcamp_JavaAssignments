package com.stackroute;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.stackroute.exception.EmptyFileException;
import com.stackroute.exception.NoRecordFoundException;

public class Stock {
	private StockRecord[] stockRecordList;
	private String filePath;
	FileReader freader;
	BufferedReader breader;

	public Stock(String fileName) throws FileNotFoundException {
		this.filePath = fileName;
		freader = new FileReader(filePath);
		breader = new BufferedReader(freader);
		this.stockRecordList = new StockRecord[0];
	}

	/* setter method stub */
	public void setFilePath(String s) {
		this.filePath = s;
	}
	
	public String getFilePath() {
		return this.filePath;
	}

	/*
	 * this method is used to find the no. of records from the file. In case the
	 * record contains null for any date, then it should be skipped
	 */
	public int countLines() throws EmptyFileException, IOException {
		freader = new FileReader(filePath);
		breader = new BufferedReader(freader);
		String fileheaders = breader.readLine();
		int lines = 0;
		while (breader.readLine() != null)
			lines++;
		breader.close();
		if (lines == 0)
			throw new EmptyFileException("No Stock Records Found");
		else
			return lines;
	}

	/*
	 * This method is responsible to read from the file and populate the array
	 * stockRecordList which is a class attribute
	 */
	public StockRecord[] readFile() throws IOException, ParseException {
		freader = new FileReader(filePath);
		breader = new BufferedReader(freader);
		String fileheaders = breader.readLine();
		String line = breader.readLine();
		while (line != null) {
			String[] record = line.split(",");
			java.util.Date recordDate = new SimpleDateFormat("dd-MM-yyyy").parse(record[0]);
			double recordOpen = Double.parseDouble(record[1]);
			double recordHigh = Double.parseDouble(record[2]);
			double recordLow = Double.parseDouble(record[3]);
			double recordClose = Double.parseDouble(record[4]);
			double recordAdj = Double.parseDouble(record[5]);
			long recordVol = Long.parseLong(record[6]);
			StockRecord newRecord = new StockRecord(recordDate, recordOpen, recordHigh, recordLow, recordClose,
					recordAdj, recordVol);

			List<StockRecord> arrlist = new ArrayList<StockRecord>(Arrays.asList(stockRecordList));
			arrlist.add(newRecord);
			stockRecordList = arrlist.toArray(stockRecordList);
			// System.out.println(newRecord);
			line = breader.readLine();
		}
		return stockRecordList;

	}

	/*
	 * This method is used to find absolute return between the first and last
	 * records
	 */
	public double findAbsoluteReturn(StockRecord[] records) throws IOException, EmptyFileException {
		StockRecord[] sortedRecords = this.sortByDate(records);
		int len = sortedRecords.length;
		double intialValue = sortedRecords[0].getClosingPrice();
		double finalvalue = sortedRecords[len - 1].getClosingPrice();
		double absReturn = (finalvalue - intialValue) / intialValue;
		return absReturn * 100;
	}

	/*
	 * This method is used to find the closing stock price on a given date. You need
	 * to handle exceptional situations such empty files, date not found etc.
	 */
	public double findClosingStockPrice(String date)
			throws NoRecordFoundException, EmptyFileException, ParseException, IOException {
		double result = 0;
		StockRecord[] sortedRecords = this.sortByDate(stockRecordList);
		java.util.Date searchDate = new SimpleDateFormat("dd-MM-yyyy").parse(date);
		for (StockRecord stockRecord : sortedRecords) {
			if (stockRecord.getDate().equals(searchDate))
				result = stockRecord.getClosingPrice();
		}
		if (result == 0)
			throw new NoRecordFoundException("No Record Found For Given Input");
		else
			return result;
	}

	/* This method is used to find absolute return between the two dates */
	public double findAbsoluteReturn(StockRecord[] records, String fromDate, String toDate)
			throws IOException, EmptyFileException, ParseException, NoRecordFoundException {
		double result = 0;
		StockRecord r1 = null, r2 = null;
		StockRecord[] sortedRecords = this.sortByDate(records);
		java.util.Date sDate = new SimpleDateFormat("dd-MM-yyyy").parse(fromDate);
		java.util.Date eDate = new SimpleDateFormat("dd-MM-yyyy").parse(toDate);
		for (StockRecord stockRecord : sortedRecords) {
			if (stockRecord.getDate().equals(sDate))
				r1 = stockRecord;
			else if (stockRecord.getDate().equals(eDate))
				r2 = stockRecord;
		}
		if (r1 == null || r2 == null)
			throw new NoRecordFoundException("No Record Found For Given Input");
		else {
			double intialValue = r1.getClosingPrice();
			double finalvalue = r2.getClosingPrice();
			double absReturn = (finalvalue - intialValue) / intialValue;
			result = absReturn * 100;
		}
		return result;

	}

	/*
	 * this method is responsible for calculating the investment value as on a given
	 * date by specifying the investment date
	 */
	public double findInvestmentValue(double investmentAmount, String investmentDate, String evaluationDate)
			throws IOException, EmptyFileException, ParseException, NoRecordFoundException {
		double result = 0;
		StockRecord r1 = null, r2 = null;
		StockRecord[] sortedRecords = this.sortByDate(stockRecordList);
		java.util.Date inDate = new SimpleDateFormat("dd-MM-yyyy").parse(investmentDate);
		java.util.Date outDate = new SimpleDateFormat("dd-MM-yyyy").parse(evaluationDate);
		for (StockRecord stockRecord : sortedRecords) {
			if (stockRecord.getDate().equals(inDate))
				r1 = stockRecord;
			else if (stockRecord.getDate().equals(outDate))
				r2 = stockRecord;
		}
		if (r1 == null || r2 == null)
			throw new NoRecordFoundException("No Record Found For Given Input");
		else {
			double intialValue = r1.getClosingPrice();
			double units = investmentAmount/intialValue;
			double finalvalue = r2.getClosingPrice();
			double evaluation = units * finalvalue;
			result = evaluation;
		}
		return result;

	}

	/* this is used to find the highest closing price for the stock */
	public double findHighestClosingStockPrice() throws IOException, EmptyFileException {
		StockRecord[] sortedRecords = this.sortByDate(stockRecordList);
		double high = sortedRecords[0].getClosingPrice();
		for (StockRecord stockRecord : sortedRecords) {
			if (stockRecord.getClosingPrice() > high)
				high = stockRecord.getClosingPrice();
		}
		return high;
	}

	/* this is used to find the lowest closing price for the stock */
	public double findLowestClosingStockPrice() throws IOException, EmptyFileException {
		StockRecord[] sortedRecords = this.sortByDate(stockRecordList);
		double low = sortedRecords[0].getClosingPrice();
		for (StockRecord stockRecord : sortedRecords) {
			if (stockRecord.getClosingPrice() < low)
				low = stockRecord.getClosingPrice();
		}
		return low;
	}

	/* this is used to sort the records in ascending order by date */
	public StockRecord[] sortByDate(StockRecord[] stockRecords) throws IOException, EmptyFileException {
		int len = this.countLines();
		StockRecord[] sortedRecords = new StockRecord[len];
		List<StockRecord> stocklist = new ArrayList<StockRecord>(Arrays.asList(stockRecords));
		List<StockRecord> sortedlist = stocklist.stream().sorted((o1, o2) -> o1.getDate().compareTo(o2.getDate()))
				.collect(Collectors.toList());
		sortedRecords = sortedlist.toArray(sortedRecords);
		return sortedRecords;
	}

	/* this is used to find the daily avg return of the stock */
	public double findAvgDailyReturn(StockRecord[] stockRecords) throws IOException, EmptyFileException {
		double total = 0;
		StockRecord[] sortedRecords = this.sortByDate(stockRecords);
		int len = sortedRecords.length;
		for(int i = 0 ; i < len - 1 ; i++ ) {
		  double change = (sortedRecords[i+1].getClosingPrice() - sortedRecords[i].getClosingPrice())/sortedRecords[i].getClosingPrice();
		  double dayreturn = change * 100;
		  total = total + dayreturn; 
		}
        return total/(len-1);
	}

//	public static void main(String[] args)
//			throws IOException, ParseException, EmptyFileException, NoRecordFoundException {
//		Stock stk = new Stock("files/CIPLA_SAMPLE.csv");
//		int len = stk.countLines();
//		System.out.println(len);
//		stockRecordList = stk.readFile();
//		System.out.println("Test " + stockRecordList[0]);
//		stk.sortByDate(stockRecordList);
//		double returns = stk.findAbsoluteReturn(stockRecordList);
//		System.out.println(returns);
//		double search = stk.findClosingStockPrice("07-08-2015");
//		System.out.println(search);
//		double high = stk.findHighestClosingStockPrice();
//		System.out.println(high);
//		double low = stk.findLowestClosingStockPrice();
//		System.out.println(low);
//		double ret = stk.findAbsoluteReturn(stockRecordList, "13-08-2015", "14-08-2015");
//		System.out.println(ret);
//		double eval = stk.findInvestmentValue(1000, "13-08-2015", "14-08-2015");
//		System.out.println(eval);
//		double avgret = stk.findAvgDailyReturn(stockRecordList);
//		System.out.println(avgret);
//	}

}
