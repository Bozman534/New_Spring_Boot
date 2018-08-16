package com.acmecorp.trader.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GeneratorData {
	
	static Date startDate = new Date();
	static int days;
	static String stockName;
	static int genID;
	static SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
	
	public static String getStartDate() {
		return formatter.format(startDate);
	}
	
	public static void setStartDate(String input) {
		
		
		try {
		startDate = formatter.parse(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int getDays() {
		return days;
	}
	
	public static void setDays(int days) {
		GeneratorData.days = days;
	}
	
	public static String getStockName() {
		return stockName;
	}
	
	public static void setStockName (String stockName) {
		GeneratorData.stockName = stockName;
	}
	
	public static int getGenID() {
		return genID;
	}
	
	public static void setGenID(int genID) {
		GeneratorData.genID = genID;
	}
}


