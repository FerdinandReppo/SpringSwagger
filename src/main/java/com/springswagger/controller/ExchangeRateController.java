package com.springswagger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springswagger.service.ExchangeRateService;


@RestController
public class ExchangeRateController {
	
	@Autowired
	public ExchangeRateService exchangeRateService;

	@RequestMapping(value = "/buyCurrency", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String buyCurrency(@RequestParam("currentCurrencyValue") int currentCurrencyValue, @RequestParam("desiredCurrency") String desiredCurrency) throws Exception{
		return exchangeRateService.getCurrencyRate(currentCurrencyValue, desiredCurrency);
	}
	
	@RequestMapping(value = "/sellCurrency", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String sellCurrency(@RequestParam("currentCurrencyValue") int currentCurrencyValue, @RequestParam("desiredCurrency") String desiredCurrency) throws Exception{
		return exchangeRateService.getCurrencyRate(currentCurrencyValue, desiredCurrency);
	}
	
}
