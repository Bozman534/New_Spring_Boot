package com.acmecorp.trader.domain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DeleteStockFile {
	
	public String deleteSpecificFile (Path filePath) {
		
		try {
		Files.delete(filePath);
		} catch (IOException e ) {
			e.printStackTrace();
			}
		
		return "Your File has been deleted";
	}

}
