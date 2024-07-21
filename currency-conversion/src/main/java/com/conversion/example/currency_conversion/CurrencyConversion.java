package com.conversion.example.currency_conversion;

import java.math.BigDecimal;

public class CurrencyConversion {
	private Long id;
	private String from;
	private String to;
	private BigDecimal cmultiple;
	private BigDecimal qty;
	private BigDecimal tca;
	private String environment;
	public CurrencyConversion() {
		
	}
	public CurrencyConversion(Long id, String from, String to, BigDecimal cmultiple, BigDecimal qty, BigDecimal tca,
			String environment) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.cmultiple = cmultiple;
		this.qty = qty;
		this.tca = tca;
		this.environment = environment;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public BigDecimal getCmultiple() {
		return cmultiple;
	}
	public void setCmultiple(BigDecimal cmultiple) {
		this.cmultiple = cmultiple;
	}
	public BigDecimal getQty() {
		return qty;
	}
	public void setQty(BigDecimal qty) {
		this.qty = qty;
	}
	public BigDecimal getTca() {
		return tca;
	}
	public void setTca(BigDecimal tca) {
		this.tca = tca;
	}
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	
	
}
