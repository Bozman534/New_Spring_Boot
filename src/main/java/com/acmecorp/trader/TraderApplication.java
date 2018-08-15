package com.acmecorp.trader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.acmecorp.trader.domain.ReadStockFile;

@SpringBootApplication
public class TraderApplication {

	public static void main(String[] args) {
		SpringApplication.run(TraderApplication.class, args);
		ReadStockFile.readStocks("GOOG");
	}
}
