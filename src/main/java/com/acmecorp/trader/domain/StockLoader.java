package com.acmecorp.trader.domain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.acmecorp.trader.domain.Stock;


public class StockLoader {

	public List<Stock> loadStocks() throws IOException  {
				
		String filePath = "/home/java/java_courses/fidelity-workshop/trader/Stocks/";
		List <Path> paths = Files.walk(Paths.get(filePath))
				.filter(Files::isRegularFile)
				.collect(Collectors.toList());
		
		List<Stock> stocks = new ArrayList<> ();
		String line = "";
		
		for (Path path: paths) {
		BufferedReader br = new BufferedReader(new FileReader(path.toFile()));
		String name = path.getFileName().toString();
		name = name.replaceAll(".csv", "");
		
			while((line = br.readLine()) != null) {
				String[] stockData = line.split(",");
				Stock tempStock = new Stock();
				
				tempStock.setName(name);
				tempStock.setDate(stockData[0]);
				tempStock.setOpen(Double.parseDouble(stockData[1]));
				tempStock.setHigh(Double.parseDouble(stockData[2]));
				tempStock.setLow(Double.parseDouble(stockData[3]));
				tempStock.setClose(Double.parseDouble(stockData[4]));
				tempStock.setVolume(Double.parseDouble(stockData[5]));
				stocks.add(tempStock);								
			}
		}
		return stocks;
	}
	
	
}
