package com.currency.currency_exchange;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name="currencyexchange")
public class CurrencyExchange {
	@Id
	private long id;
	@Column(name="currency_from")
	private String from;
	@Column(name="currency_to")
	private String to;
	private BigDecimal cmultiple;
	private String environment;
	public CurrencyExchange() {
		super();
	}
	public CurrencyExchange(long id, String from, String to, BigDecimal cmultiple) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.cmultiple = cmultiple;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	
	
}
