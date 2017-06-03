package at.tuwien.ss17.dp.lab3.datascience.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import at.tuwien.ss17.dp.lab3.datascience.model.Weather;

public interface WeatherRespository extends MongoRepository<Weather, String>{

}
