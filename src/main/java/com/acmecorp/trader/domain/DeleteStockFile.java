package com.acmecorp.trader.domain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DeleteStockFile {
	
	public static String deleteSpecificFile (String stockName) throws IOException {
		
		String filePath = "/home/java/java_courses/fidelity-workshop/trader/Stocks/" + stockName + ".csv";
		
		Files.delete(Paths.get(filePath));

		return "Your File has been deleted";
	}

}
