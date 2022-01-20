package com.springswagger.service;

public interface ExchangeRateService {
	
	public String getCurrencyRate(int currentCurrencyValue, String desiredCurrency) throws Exception;

}
