package at.tuwien.ss17.dp.lab3.datascience.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import at.tuwien.ss17.dp.lab3.datascience.model.Weather;
import at.tuwien.ss17.dp.lab3.datascience.service.WeatherService;

@RequestMapping(value="/weather")
@RestController
public class WeatherController {

	private static final Logger logger = LoggerFactory.getLogger(WeatherController.class);
	
	@Autowired
	private WeatherService weatherService;
	
	@RequestMapping(value="/findAll", method = RequestMethod.GET)
	public List<Weather> getAllChannels(){
		logger.info("Request Receive- getAllChannels");
		return weatherService.findAll();
	}
	
}
