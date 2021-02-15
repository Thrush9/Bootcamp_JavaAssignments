package com.stackroute.test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.stackroute.Stock;
import com.stackroute.StockRecord;
import com.stackroute.exception.EmptyFileException;
import com.stackroute.exception.NoRecordFoundException;

public class StockTest {
	
	private static final String MSG_01 = "file path should be set and get as per input";
	private static final String MSG_02 = "count no.of records in given file";
	private static final String MSG_03 = "count the records and convert in to StockRecords";
	private static final String MSG_04 = "calculate absolute return between first and last record";
	private static final String MSG_05 = "get closing price for given input";
	private static final String MSG_06 = "calculate absolute return between given input dates";
	private static final String MSG_07 = "Calucalte investment for given date and estimate for other date";
	private static final String MSG_08 = "get highest closing price in the given date";
	private static final String MSG_09 = "get lowest closing price in the given date";
	private static final String MSG_10 = "should sort records based on dates in ascending order";
	private static final String MSG_11 = "Calculate avg daily return for given data";
	
	private Stock stock;
	private StockRecord rec ;

	@BeforeEach
	public void setUp() throws FileNotFoundException {
		stock = new Stock("files/CIPLA_SAMPLE.csv");
		rec = new StockRecord();
	}

	@AfterEach
	public void tearDown() {
		stock = null;
		rec = null;
	}

	@Test
	public void checkFileNotFoundException() {
		assertThrows(FileNotFoundException.class,() -> stock = new Stock("files/CIPLA-SAMPLE.csv"));
	}
		
	@Test
	public void checkSetFilePath() {
		stock.setFilePath("files/CIPLA_SAMPLE1.csv");
		assertEquals("files/CIPLA_SAMPLE1.csv",stock.getFilePath(), MSG_01);
	}
	
	@Test
	public void checkCountLinesSuccess() throws EmptyFileException, IOException {
		assertEquals(10,stock.countLines(),MSG_02);
	}
	
	@Test
	public void checkCountLinesFailure() throws EmptyFileException, IOException {
		stock = new Stock("files/CIPLA_TEST.csv");
		assertThrows(EmptyFileException.class,() -> stock.countLines());
	}
	
	@Test
	public void checkReadFileSuccess() throws IOException, ParseException  {
		assertEquals(10,stock.readFile().length,MSG_03);
	}
	
	@Test
	public void checkFindAbsoluteReturnSuccess() throws IOException, ParseException, EmptyFileException  {
		StockRecord[] records = stock.readFile();
		double returns = stock.findAbsoluteReturn(records);
		assertNotNull(returns);
		assertEquals(3.8326531601738543,returns,MSG_04);
	}
	
	@Test
	public void checkFindClosingStockPriceSuccess() throws NoRecordFoundException, EmptyFileException, ParseException, IOException {
		StockRecord[] records = stock.readFile();
		double price = stock.findClosingStockPrice("13-08-2015");
		assertNotNull(price);
		assertEquals(725.5,price,MSG_05);
	}
	
	@Test
	public void checkFindClosingStockPriceFailure() throws NoRecordFoundException, EmptyFileException, ParseException, IOException {
		StockRecord[] records = stock.readFile();;
		assertThrows(NoRecordFoundException.class,() -> stock.findClosingStockPrice("19-08-2015"));
	}
	
	@Test
	public void checkFindAbsoluteReturnBetweenDatesSucess() throws IOException, ParseException, NoRecordFoundException, EmptyFileException {
		StockRecord[] records = stock.readFile();
		double price = stock.findAbsoluteReturn(records, "13-08-2015", "14-08-2015");
		assertNotNull(price);
		assertEquals(1.9434839421088863,price,MSG_06);
	}
	
	@Test
	public void checkFindAbsoluteReturnBetweenDatesFailure() throws IOException, ParseException, NoRecordFoundException, EmptyFileException {
		StockRecord[] records = stock.readFile();
		assertThrows(NoRecordFoundException.class,() -> stock.findAbsoluteReturn(records, "13-08-2015", "19-08-2015"));
	}
	
	@Test
	public void checkFindInvestmentValueSucess() throws IOException, ParseException, NoRecordFoundException, EmptyFileException {
		StockRecord[] records = stock.readFile();
		double price = stock.findInvestmentValue(1000, "13-08-2015", "14-08-2015");
		assertNotNull(price);
		assertEquals(1019.4348394210888,price,MSG_07);
	}
	
	@Test
	public void checkFindInvestmentValueFailure() throws IOException, ParseException, NoRecordFoundException, EmptyFileException {
		StockRecord[] records = stock.readFile();
		assertThrows(NoRecordFoundException.class,() -> stock.findInvestmentValue(1000, "13-08-2015", "19-08-2015"));
	}
	
	@Test
	public void checkHighestClosingStockPriceSucess() throws IOException, ParseException, EmptyFileException  {
		StockRecord[] records = stock.readFile();
		double price = stock.findHighestClosingStockPrice();
		assertNotNull(price);
		assertEquals(739.599976,price,MSG_08);
	}
	
	@Test
	public void checkLowestClosingStockPriceSucess() throws IOException, ParseException, EmptyFileException  {
		StockRecord[] records = stock.readFile();
		double price = stock.findLowestClosingStockPrice();
		assertNotNull(price);
		assertEquals(707.650024,price,MSG_09);
	}
	
	@Test
	public void checkSortByDateSuccess() throws IOException, ParseException, EmptyFileException {
		StockRecord[] records = stock.readFile();
		StockRecord[] sortedRecords = stock.sortByDate(records);
		assertEquals(712.299988,sortedRecords[0].getClosingPrice(),MSG_10);
		assertEquals(716.950012,sortedRecords[0].getDayHighPrice(),MSG_10);
		assertEquals(705,sortedRecords[0].getDayLowPrice(),MSG_10);
		assertEquals(735,sortedRecords[9].getOpeningPrice(),MSG_10);
		assertEquals(724.79303,sortedRecords[9].getAdjClosingPrice(),MSG_10);
		assertEquals(3238561,sortedRecords[9].getVolume(),MSG_10);
	}
	
	@Test
	public void checkAvgDailyReturnSucess() throws IOException, ParseException, EmptyFileException  {
		StockRecord[] records = stock.readFile();
		double price = stock.findAvgDailyReturn(records);
		assertNotNull(price);
		assertEquals(0.426985976530613,price,MSG_11);
	}
	
	@Test
	public void checkStockRecordObject() throws ParseException {
		java.util.Date recordDate = new SimpleDateFormat("dd-MM-yyyy").parse("01-01-2021");
		rec.setDate(recordDate);
		rec.setOpeningPrice(800.35);
		rec.setDayHighPrice(815.3879);
		rec.setDayLowPrice(803.2439);
		rec.setClosingPrice(807.98778);
		rec.setAdjClosingPrice(805.567323);
		rec.setVolume(4856356);
		assertNotNull(rec.toString());
	}
	
}
