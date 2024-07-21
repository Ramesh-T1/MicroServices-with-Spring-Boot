package com.currency.currency_exchange;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	@Autowired
	private Environment environment;
	@Autowired
	private CurrencyExchangeRepository repository;
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(@PathVariable String from,@PathVariable String to)
	{
		//This is hardcoded
		//CurrencyExchange c=new CurrencyExchange(1000L,from,to,BigDecimal.valueOf(100));
		//Removing hard coding
		CurrencyExchange c=repository.findByFromAndTo(from,to);
		if(c==null)
		{
			throw new RuntimeException("No data found with parameters provided");
		}
		String port=environment.getProperty("local.server.port");
		c.setEnvironment(port);
		return c;
	}

}
