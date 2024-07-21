package com.conversion.example.currency_conversion;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {
	@Autowired
	CurrencyExchangeProxy proxy;

	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{qty}")
	public CurrencyConversion calculateCurrencyConversion(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal qty) {
		// hard coded
		// return new
		// CurrencyConversion(2000L,from,to,BigDecimal.ONE,qty,BigDecimal.ONE,"");
		// Calling CurrencyExchange Microservice
		HashMap<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		ResponseEntity<CurrencyConversion> re = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, uriVariables);
		CurrencyConversion conv = re.getBody();
		return new CurrencyConversion(conv.getId(), from, to, conv.getCmultiple(), qty,
				qty.multiply(conv.getCmultiple()), conv.getEnvironment());
	}
	
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{qty}")
	public CurrencyConversion calculateCurrencyConversionFeign(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal qty)
	{
		CurrencyConversion c=proxy.callExchangeValue(from, to);
		return new CurrencyConversion(c.getId(),from,to,c.getCmultiple(),qty,qty.multiply(c.getCmultiple()),c.getEnvironment()) ;
		
	}

}