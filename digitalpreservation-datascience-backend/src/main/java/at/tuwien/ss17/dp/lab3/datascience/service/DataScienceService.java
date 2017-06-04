package at.tuwien.ss17.dp.lab3.datascience.service;

import java.util.List;

import at.tuwien.ss17.dp.lab3.datascience.model.Data;
import at.tuwien.ss17.dp.lab3.datascience.model.Weather;

public interface DataScienceService {

	List<Weather> getWeatherAllData();

	String getWeatherByChannel(String channel);

	String getAllChannels();

	Data getApiData();

}
