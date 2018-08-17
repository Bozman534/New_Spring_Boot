package com.acmecorp.trader.domain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class ReadStockFile {

	public static List<String> readStocks (String stockName) throws IOException {
		
		String filePath = "/home/java/java_courses/fidelity-workshop/trader/Stocks/" + stockName + ".csv";

		List<String> stockList = Files.lines(Paths.get(filePath))
				.collect(Collectors.toList());
		
		return stockList;
		
	}

	public static List<String> readAllStockFiles () throws IOException {
		
		String filePath = "/home/java/java_courses/fidelity-workshop/trader/Stocks/";
		List <Path> paths = Files.walk(Paths.get(filePath))
				.filter(Files::isRegularFile)
				.collect(Collectors.toList());
		
		List<String> fileNames = new ArrayList <String> ();
		paths.stream().forEach(p -> fileNames.add(p.getFileName().toString()));
		
		fileNames.removeIf(p -> p.startsWith("."));
				
		return fileNames;
		
		


	}
		
	}
	

