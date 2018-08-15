package com.acmecorp.trader.domain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReadStockFile {

	public static Stream<String> readStocks (String stockName) {
		
		String filePath = "/home/java/java_courses/fidelity-workshop/trader/" + stockName + ".csv";
		
		Stream <String> stockStream = null;
		
		try {
		stockStream = Files.lines(Paths.get(filePath));
		} catch (IOException e) {
			e.printStackTrace();
			}
		
		stockStream.forEach(System.out::println);
		return stockStream;
		
	}
	
}
