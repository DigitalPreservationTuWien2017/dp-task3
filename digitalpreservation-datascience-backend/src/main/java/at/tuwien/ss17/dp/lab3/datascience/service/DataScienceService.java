package at.tuwien.ss17.dp.lab3.datascience.service;

import java.util.List;

<<<<<<< HEAD
<<<<<<< HEAD
import at.tuwien.ss17.dp.lab3.datascience.model.Data;
=======
>>>>>>> 82d8c4ba981a459f9b1136db32ac23b0012bab6e
=======
import at.tuwien.ss17.dp.lab3.datascience.model.Data;
>>>>>>> bc488855ecbfb873257992d1dec817bbfac4a278
import at.tuwien.ss17.dp.lab3.datascience.model.Weather;

public interface DataScienceService {

	List<Weather> getWeatherAllData();

	String getWeatherByChannel(String channel);

	String getAllChannels();

<<<<<<< HEAD
<<<<<<< HEAD
	Data getApiData();

=======
>>>>>>> 82d8c4ba981a459f9b1136db32ac23b0012bab6e
=======
	Data getApiData();

>>>>>>> bc488855ecbfb873257992d1dec817bbfac4a278
}
