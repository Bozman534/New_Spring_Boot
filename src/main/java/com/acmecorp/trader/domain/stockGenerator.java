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
	
	public static boolean generateStocks (Date startDate, int days, String stockName, int genID) {
		
		Path filePath = Paths.get("/home/java/java_courses/fidelity-workshop/trader/" + stockName + ".csv");
		
		//creating the file
		try {
			Files.createFile(filePath);
		} catch (IOException e) {
			e.printStackTrace();
			}
		//creating the data
		
		List<String> rowContent = new ArrayList<String>(); 
		double open;
		double high;
		double low;
		double close;
		double volume;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(startDate);

		rowContent.add("Date,Open,High,Low,Close,Volume");
		
		for (int i = 1; i <= days; i++){
			open = 80 * (1.1 * Math.random());
			high = 85 * (1.1 * Math.random());
			low = 75 * (1.1 * Math.random());
			close = 80 * (1.1 * Math.random());
			volume = 2000000 * (1.2 * Math.random());
			
			rowContent.add(formatter.format(c.getTime()) + "," + open + "," + high + "," + low + "," + close + "," + volume);
			c.add(Calendar.DAY_OF_MONTH, 1);
		}

		try {
	
		Files.write(filePath, rowContent, StandardOpenOption.APPEND);
		
		} catch (IOException e) {
			e.printStackTrace();
			}		
		
		return true;
	}

}
