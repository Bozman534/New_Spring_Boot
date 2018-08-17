package com.acmecorp.trader.endpoints;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acmecorp.trader.domain.StockGenerator;
import com.acmecorp.trader.domain.GeneratorData;
import com.acmecorp.trader.domain.ReadStockFile;
import com.acmecorp.trader.domain.Stock;
import com.acmecorp.trader.domain.DeleteStockFile;

@RestController
@RequestMapping ("/stocks")
public class MethodEndpoint {

	@GetMapping (value = "/generator/get/genID")
	public String generatorMetaData () {
		int genID = GeneratorData.getGenID();
		return "GenID = " + genID + " " + StockGenerator.generatorMetadata(genID);
		
	}
	
	@GetMapping (value = "/generator/set/genID/{genID}")
	public String setGeneratorGenID (@PathVariable int genID) {
		GeneratorData.setGenID(genID);
		return "Your generator ID has been set to " + genID + ". " + StockGenerator.generatorMetadata(genID);
	}
	
	@GetMapping (value = "/generator/get/startDate")
	public String getGeneratorStartDate () {
		return GeneratorData.getStartDate();
	}
	
	@GetMapping (value = "/generator/set/startDate/{startDate}") 
	public String setGeneratorStartDate(@PathVariable String startDate) {
		GeneratorData.setStartDate(startDate);
		return "Your generator start date has been set to " + startDate;
	}
	
	@GetMapping (value = "/generator/get/stockName")
	public String getGeneratorStockName () {
		return GeneratorData.getStockName();
	}
	
	@GetMapping (value = "/generator/set/stockName/{stockName}")
	public String setGeneratorStockName (@PathVariable String stockName) {
		GeneratorData.setStockName(stockName);
		return "Your generator stock name has been set to " + stockName;
	}
	
	@GetMapping (value = "/generator/get/days")
	public int getGeneratorDays () {
		return GeneratorData.getDays();
	}
	
	@GetMapping (value = "/generator/set/days/{days}")
	public String setGeneratorDays (@PathVariable int days) {
		GeneratorData.setDays(days);
		return "Your generator days have been set to " + days;
	}
	
	@GetMapping (value = "/generator/generate")
	public String generatorGenerate () throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
		String status = StockGenerator.generateStocks(formatter.parse(GeneratorData.getStartDate()), GeneratorData.getDays(),
				GeneratorData.getStockName(), GeneratorData.getGenID());
		return status;
		
	}
	
	@GetMapping (value = "/read/{stockName}")
	public List<String>  readStockFile (@PathVariable String stockName) throws IOException {
		List <String> stockList = new ArrayList <String> ();

		stockList = ReadStockFile.readStocks(stockName);
		
		return stockList;
	}
	
	@GetMapping (value = "/read/AllFiles")
	public List<String> readAllFiles () throws IOException {
		List <String> stockFiles = new ArrayList <String> ();
		stockFiles = ReadStockFile.readAllStockFiles();
		stockFiles.add(0, "There are " + stockFiles.size() + " stock files available. They are:");
		return stockFiles;
		
	}
	
	@GetMapping (value = "/delete/{stockName}")
	public String deleteFile (@PathVariable String stockName) throws IOException {
		return DeleteStockFile.deleteSpecificFile(stockName);
	}
	
	@GetMapping (value = "/read/AllStocks")
	public List<Stock> readAllStocks () throws IOException {
		return readAllStocks();
		}
	
}
