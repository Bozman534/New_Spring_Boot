package com.acmecorp.trader.domain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.nio.charset.StandardCharsets;

public class stockGenerator {

	
	
	public static String generateStocks (Date startDate, int days, String stockName, int genID) {
		String status = "default status";
		
		//create the Path
		Path filePath = Paths.get("/home/java/java_courses/fidelity-workshop/trader/" + stockName + ".csv");
		

		//creating the data
		List<String> rowContent = new ArrayList<String>(); 
		double open;
		double high;
		double low;
		double close;
		double volume;
		String mocked = "mocked";

		
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(startDate);
		
		rowContent.add("Date,Open,High,Low,Close,Volume,mocked");
		
		
		if (genID == 1) {
			
		for (int i = 1; i <= days; i++){
			open = 80 * (1.1 * Math.random());
			high = 85 * (1.1 * Math.random());
			low = 75 * (1.1 * Math.random());
			close = 80 * (1.1 * Math.random());
			volume = 2000000 * (1.2 * Math.random());
			
			rowContent.add(formatter.format(c.getTime()) + "," + open + "," + high + "," + low + "," + close + "," + volume + "," + mocked);
			c.add(Calendar.DATE, 1);
			status = "Your file has been successfully created";
		}
		} else if (genID == 2) {
			
		for (int i = 1; i <= days; i++){
			open = 100 * (1.1 * Math.random());
			high = 115 * (1.1 * Math.random());
			low = 85 * (1.1 * Math.random());
			close = 85 * (1.1 * Math.random());
			volume = 2000000 * (1.2 * Math.random());
			
			rowContent.add(formatter.format(c.getTime()) + "," + open + "," + high + "," + low + "," + close + "," + volume + "," + mocked);
			c.add(Calendar.DATE, 1);}
			status = "Your file has been successfully created";
			
			
		} else if (genID == 3) {
			for (int i = 1; i <= days; i++){
				open = 160 * (1.1 * Math.random());
				high = 200 * (1.1 * Math.random());
				low = 120 * (1.1 * Math.random());
				close = 160 * (1.1 * Math.random());
				volume = 2000000 * (1.2 * Math.random());
				
				rowContent.add(formatter.format(c.getTime()) + "," + open + "," + high + "," + low + "," + close + "," + volume + "," + mocked);
				c.add(Calendar.DATE, 1);}
				status = "Your file has been successfully created";
		} else {
			
			status = "Please pass a valid genID you chowder head";
			
		}
		
		
		try {
	
		Files.write(filePath, rowContent, StandardOpenOption.APPEND, StandardOpenOption.CREATE);

		
		} catch (IOException e) {
			e.printStackTrace();
			}
		return status;		
		

	}
	
	public static String generatorMetadata(int genID) {
		String metaData;
		
		if (genID == 1) {
			metaData = "This generates low value stocks";
		} else if (genID == 2) {
			metaData = "This generates medium value stocks";
		} else if (genID == 3) {
			metaData = "This generates high value stocks";
		} else {
			metaData = "This is not a valid generator ID";
		}
		
		return metaData;
	}

}
