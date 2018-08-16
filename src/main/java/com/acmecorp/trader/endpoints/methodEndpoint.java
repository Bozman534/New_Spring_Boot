package com.acmecorp.trader.endpoints;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acmecorp.trader.domain.stockGenerator;
import com.acmecorp.trader.domain.GeneratorData;

@RestController
@RequestMapping ("/stocks")
public class methodEndpoint {

	@GetMapping (value = "/generator/get/genID")
	public String generatorMetaData () {
		int genID = GeneratorData.getGenID();
		return "GenID = " + genID + " " + stockGenerator.generatorMetadata(genID);
		
	}
	
	@GetMapping (value = "/generator/set/genID/{genID}")
	public String setGeneratorGenID (@PathVariable int genID) {
		GeneratorData.setGenID(genID);
		return "Your generator ID has been set to " + genID;
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
	
	
}
