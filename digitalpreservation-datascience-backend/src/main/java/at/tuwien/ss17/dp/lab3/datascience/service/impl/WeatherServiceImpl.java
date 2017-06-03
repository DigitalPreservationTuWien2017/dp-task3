package at.tuwien.ss17.dp.lab3.datascience.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.tuwien.ss17.dp.lab3.datascience.exception.WeatherNotFoundException;
import at.tuwien.ss17.dp.lab3.datascience.model.Weather;
import at.tuwien.ss17.dp.lab3.datascience.repository.WeatherRespository;
import at.tuwien.ss17.dp.lab3.datascience.service.WeatherService;

@Service(value="weatherService")
public class WeatherServiceImpl implements WeatherService{

	@Autowired
	private WeatherRespository weatherRepository;
	
	@Override
	public Weather create(Weather weather) {
		return weatherRepository.save(weather);
	}


	@Override
	public List<Weather> findAll() {
		return weatherRepository.findAll();
	}

	@Override
	public Weather findById(Long channel) throws WeatherNotFoundException {
		return weatherRepository.findOne(String.valueOf(channel));
	}

	@Override
	public Weather update(Weather weather) {
		return weatherRepository.save(weather);
	}
	
}
