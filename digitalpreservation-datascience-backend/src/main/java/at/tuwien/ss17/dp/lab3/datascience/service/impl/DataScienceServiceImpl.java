package at.tuwien.ss17.dp.lab3.datascience.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import at.tuwien.ss17.dp.lab3.datascience.model.Weather;
import at.tuwien.ss17.dp.lab3.datascience.repository.WeatherRespository;
import at.tuwien.ss17.dp.lab3.datascience.service.DataScienceService;
import at.tuwien.ss17.dp.lab3.datascience.service.WeatherService;

@Service(value = "dataScienceService")
public class DataScienceServiceImpl implements DataScienceService {

	private static final Logger logger = LoggerFactory.getLogger(DataScienceServiceImpl.class);

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WeatherService weatherService;

	@Value("${weather.endpoint.all-weather-data}")
	private String allWeatherDataURI;

	@Value("${weather.endpoint.all-channels}")
	private String allChannelsURI;

	@Value("${weather.endpoint.single-channel}")
	private String singleChannelsURI;

	@Override
	public List<Weather> getWeatherAllData() {
		logger.info("getWeatherAllData URI:", allWeatherDataURI);
		String result = restTemplate.getForObject(allWeatherDataURI, String.class);
		return parseStringToWeatherList(result);
	}

	private List<Weather> parseStringToWeatherList(String result) {

		String[] list = result.split("\n");
		List<Weather> weatherList = new ArrayList<Weather>();

		if (list == null || list.length == 0)
			new ArrayList<Weather>();

		for (int line = 0; line < list.length; line++) {
			logger.info("Line " + line);
			logger.info(list[line]);
			String[] columns = list[line].split(";");
			Weather weather = new Weather(columns[0], columns[1], columns[3], columns[4],columns[5], columns[6], columns[7]);
			weatherList.add(weather);
			weatherService.create(weather);
		}

		return weatherList;
	}

	@Override
	public String getWeatherByChannel(String channel) {
		logger.info("getWeatherByChannel");
		String completeURI = singleChannelsURI + channel + "/t";
		logger.info(" URI:", completeURI);
		return restTemplate.getForObject(completeURI, String.class);
	}

	@Override
	public String getAllChannels() {
		logger.info("getAllChannels URI:" + allChannelsURI);
		return restTemplate.getForObject(allChannelsURI, String.class);
	}

}
