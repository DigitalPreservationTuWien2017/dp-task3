package at.tuwien.ss17.dp.lab3.datascience.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import at.tuwien.ss17.dp.lab3.datascience.model.DataWrapper;
import at.tuwien.ss17.dp.lab3.datascience.model.Weather;
import at.tuwien.ss17.dp.lab3.datascience.service.DataScienceService;

@RestController
public class DataScienceController {
	
	private static final Logger logger = LoggerFactory.getLogger(DataScienceController.class);
	
	@Autowired
	private DataScienceService dataScienceService;
	
	@RequestMapping(value="/getAllChannels", method = RequestMethod.GET)
	public String getAllChannels(){
		logger.info("Request Receive- getAllChannels");
		return dataScienceService.getAllChannels();
	}
	
	@RequestMapping(value="/getWeatherAllData", method = RequestMethod.GET)
	public List<Weather> getWeatherAllData(){
		logger.info("Request Receive- getWeatherAllData");
		return dataScienceService.getWeatherAllData();
	}

	@RequestMapping(value="/getApiData", method = RequestMethod.GET)
	public DataWrapper getApiData(){
		logger.info("Request Receive- getApiData");
		return new DataWrapper(dataScienceService.getApiData());
	}

	@RequestMapping(value="/getWeatherByChannel", method = RequestMethod.GET)
	public String getWeatherByWeather(@RequestParam String channelId){
		logger.info("Request Received - getWeatherByWeather: "+channelId);
		return dataScienceService.getWeatherByChannel(channelId);
	}

}
