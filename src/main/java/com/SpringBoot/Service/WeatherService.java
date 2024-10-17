package com.SpringBoot.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.SpringBoot.Configuration.KafkaConstants;
import com.SpringBoot.Model.WeatherResponse;

//fetching data from OpenWeatherApp

@Service
public class WeatherService {

	
	private static final String API_KEY = "8a9c77dbf7e185d8c4362643615fb029";  
	private static final String WEATHER_API_URL = "https://api.openweathermap.org/data/2.5/weather";
	private final RestTemplate restTemplate;
	
	public WeatherService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	


	public WeatherResponse getWeatherData(String city) {
		// Build the URL with query parameters
		String url = UriComponentsBuilder.fromHttpUrl(WEATHER_API_URL)
				.queryParam("q", city)
				.queryParam("appid", API_KEY)
				.queryParam("units", "metric") // Optional: fetch temperature in Celsius
				.build()
				.toString();

		// Make an API call and return the response as a String
		return restTemplate.getForObject(url, WeatherResponse.class);
	}
}

