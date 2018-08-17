package com.acmecorp.trader.domain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;




public class Stock 
{

	static String name;
	static String date;
	static double open;
	static double high;
	static double low;
	static double close;
	static double volume;
	static String mocked;
	
	public Stock() {
		Stock.name = "DEF";
		Stock.date = "08-17-2018";
		Stock.open = 67;
		Stock.high = 87;
		Stock.low = 66;
		Stock.close = 68;
		Stock.volume = 20102002;
		Stock.mocked = "mocked";
			
	}
	
	public String getName () {
		return name;
	}
	
	public void setName (String name) {
		Stock.name = name;
	}
	
	public String getDate () {
		return date;
	}
	
	public void setDate (String date) {
		Stock.date = date;
	}
	
	public double getOpen () {
		return open;
	}
	
	public void setOpen (double open) {
		Stock.open = open;
	}
	
	public double getHigh () {
		return high;
	}
	
	public void setHigh (double high) {
		Stock.high = high;
	}
	
	public double getLow () {
		return low;
	}
	
	public void setLow (double low) {
		Stock.low = low;
	}
	
	public double getClose () {
		return close;
	}
	
	public void setClose (double close) {
		Stock.close = close;
	}
	
	public double getVolume() {
		return volume;
		}
	
	public void setVolume(double volume) {
		Stock.volume = volume;
	}

	public String getMocked ()  {
		return mocked;
		}
	
	public void setMocked (String mocked) {
		Stock.mocked = mocked;
	}
	
	
	
}
