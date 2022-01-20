package com.springswagger.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.springswagger.service.ExchangeRateService;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {
	
	public String getCurrencyRate(int currentCurrencyValue, String desiredCurrency) throws Exception {
		String ratesURL = "http://api.exchangeratesapi.io/v1/latest?access_key=b600d64018e99b531b3906375159fbdf";
		URL url = new URL(ratesURL);
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
		httpURLConnection.setRequestMethod("GET");
		int responseCode = httpURLConnection.getResponseCode();
		JSONObject finalDataSourceObjects = new JSONObject();
		finalDataSourceObjects.put("Exchanged Value", "N/A");
		if(responseCode == HttpURLConnection.HTTP_OK) {
			BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			
			while((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}in.close();
			
			JSONObject obj = new JSONObject(response.toString());
			Double exchangeRate = obj.getJSONObject("rates").getDouble(desiredCurrency);
			Double finalConvertedValue = currentCurrencyValue * exchangeRate;
			finalDataSourceObjects.put("Base Currency", "EUR");
			finalDataSourceObjects.put("Desired Currency", desiredCurrency);
			finalDataSourceObjects.put("Exchanged Value", finalConvertedValue);
		}

		return finalDataSourceObjects.toString();
	}

}
