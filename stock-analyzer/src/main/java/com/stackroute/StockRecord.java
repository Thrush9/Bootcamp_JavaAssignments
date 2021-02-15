package com.stackroute;

import java.util.Date;

public class StockRecord {

    private Date date;
    private double openingPrice;
    private double dayHighPrice;
    private double dayLowPrice;
    private double closingPrice;
    private double adjClosingPrice;
    private long volume;

    public StockRecord() {

    }

    public StockRecord(Date date, double open, double high, double low, double close, double adjclose, long vol) {
      this.date = date;
      this.openingPrice = open;
      this.dayHighPrice = high;
      this.dayLowPrice = low;
      this.closingPrice = close;
      this.adjClosingPrice = adjclose;
      this.volume = vol;
    }

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getOpeningPrice() {
		return openingPrice;
	}

	public void setOpeningPrice(double openingPrice) {
		this.openingPrice = openingPrice;
	}

	public double getDayHighPrice() {
		return dayHighPrice;
	}

	public void setDayHighPrice(double dayHighPrice) {
		this.dayHighPrice = dayHighPrice;
	}

	public double getDayLowPrice() {
		return dayLowPrice;
	}

	public void setDayLowPrice(double dayLowPrice) {
		this.dayLowPrice = dayLowPrice;
	}

	public double getClosingPrice() {
		return closingPrice;
	}

	public void setClosingPrice(double closingPrice) {
		this.closingPrice = closingPrice;
	}

	public double getAdjClosingPrice() {
		return adjClosingPrice;
	}

	public void setAdjClosingPrice(double adjClosingPrice) {
		this.adjClosingPrice = adjClosingPrice;
	}

	public long getVolume() {
		return volume;
	}

	public void setVolume(long volume) {
		this.volume = volume;
	}

	@Override
	public String toString() {
		return "StockRecord [date=" + date + ", openingPrice=" + openingPrice + ", dayHighPrice=" + dayHighPrice
				+ ", dayLowPrice=" + dayLowPrice + ", closingPrice=" + closingPrice + ", adjClosingPrice="
				+ adjClosingPrice + ", volume=" + volume + "]";
	}
    
    
}
