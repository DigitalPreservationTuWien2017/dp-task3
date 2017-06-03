package at.tuwien.ss17.dp.lab3.datascience.service;

import java.util.List;

import at.tuwien.ss17.dp.lab3.datascience.exception.WeatherNotFoundException;
import at.tuwien.ss17.dp.lab3.datascience.model.Weather;

public interface WeatherService {

	Weather create(Weather weather);
	 
    List<Weather> findAll();
 
    Weather update(Weather weather);

	Weather findById(Long i) throws WeatherNotFoundException;
    
}
