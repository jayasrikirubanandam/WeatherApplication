package com.SpringBoot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.SpringBoot.Model.WeatherResponse;
import com.SpringBoot.Service.WeatherService;





@RestController
public class WeatherController {


	@Autowired
	private WeatherService weatherService;

	@GetMapping("/fetch-weather")
	public WeatherResponse fetchWeather(@RequestParam("city") String city) {
		// Fetch weather data from the WeatherService
		return  weatherService.getWeatherData(city);

		// Return the weather data as a response
		
	}
	
	
}
