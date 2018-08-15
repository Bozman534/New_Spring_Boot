package com.acmecorp.trader.domain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.stream.Stream;
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
		
		Stream<String> rowContent = Stream.of("Date,Open,High,Low,Close,Volume");
		
		//For (int day)

		
		try {
		Files.write(filePath, rowContent.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
			}		
		
		return true;
	}

}
