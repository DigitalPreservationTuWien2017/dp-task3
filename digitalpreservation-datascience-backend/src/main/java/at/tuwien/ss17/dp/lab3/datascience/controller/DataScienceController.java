package at.tuwien.ss17.dp.lab3.datascience.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
<<<<<<< HEAD
import at.tuwien.ss17.dp.lab3.datascience.model.Data;
import at.tuwien.ss17.dp.lab3.datascience.model.DataWrapper;
=======
>>>>>>> 82d8c4ba981a459f9b1136db32ac23b0012bab6e
=======
import at.tuwien.ss17.dp.lab3.datascience.model.Data;
import at.tuwien.ss17.dp.lab3.datascience.model.DataWrapper;
>>>>>>> bc488855ecbfb873257992d1dec817bbfac4a278
import at.tuwien.ss17.dp.lab3.datascience.model.Weather;
import at.tuwien.ss17.dp.lab3.datascience.service.DataScienceService;

@RestController
public class DataScienceController {
	
	private static final Logger logger = LoggerFactory.getLogger(DataScienceController.class);
	
	@Autowired
	private DataScienceService dataScienceService;
	
	@RequestMapping(value="/getAllChannels")
	public String getAllChannels(){
		logger.info("Request Receive- getAllChannels");
		return dataScienceService.getAllChannels();
	}
	
	@RequestMapping(value="/getWeatherAllData")
	public List<Weather> getWeatherAllData(){
		logger.info("Request Receive- getWeatherAllData");
		return dataScienceService.getWeatherAllData();
	}

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> bc488855ecbfb873257992d1dec817bbfac4a278
	@RequestMapping(value="/getApiData")
	public DataWrapper getApiData(){
		logger.info("Request Receive- getApiData");
		return new DataWrapper(dataScienceService.getApiData());
	}

<<<<<<< HEAD
=======
>>>>>>> 82d8c4ba981a459f9b1136db32ac23b0012bab6e
=======
>>>>>>> bc488855ecbfb873257992d1dec817bbfac4a278
	@RequestMapping(value="/getWeatherByChannel")
	public String getWeatherByWeather(@RequestParam String channelId){
		logger.info("Request Received - getWeatherByWeather: "+channelId);
		return dataScienceService.getWeatherByChannel(channelId);
	}

}
