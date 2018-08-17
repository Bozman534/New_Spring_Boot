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
	@Autowired
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
	
	public static void setName (String name) {
		Stock.name = name;
	}
	
	public static String getDate () {
		return date;
	}
	
	public static void setDate (String date) {
		Stock.date = date;
	}
	
	public static double getOpen () {
		return open;
	}
	
	public static void setOpen (double open) {
		Stock.open = open;
	}
	
	public static double getHigh () {
		return high;
	}
	
	public static void setHigh (double high) {
		Stock.high = high;
	}
	
	public static double getLow () {
		return low;
	}
	
	public static void setLow (double low) {
		Stock.low = low;
	}
	
	public static double getClose () {
		return close;
	}
	
	public static void setClose (double close) {
		Stock.close = close;
	}
	
	public static double getVolume() {
		return volume;
		}
	
	public static void setVolume(double volume) {
		Stock.volume = volume;
	}

	public static String getMocked ()  {
		return mocked;
		}
	
	public static void setMocked (String mocked) {
		Stock.mocked = mocked;
	}
	
	
	
}
