package at.tuwien.ss17.dp.lab3.datascience.service.impl;

<<<<<<< HEAD
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
=======
import java.util.ArrayList;
import java.util.List;
>>>>>>> 82d8c4ba981a459f9b1136db32ac23b0012bab6e

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

<<<<<<< HEAD
import at.tuwien.ss17.dp.lab3.datascience.model.Data;
import at.tuwien.ss17.dp.lab3.datascience.model.Weather;
=======
import at.tuwien.ss17.dp.lab3.datascience.model.Weather;
import at.tuwien.ss17.dp.lab3.datascience.repository.WeatherRespository;
>>>>>>> 82d8c4ba981a459f9b1136db32ac23b0012bab6e
import at.tuwien.ss17.dp.lab3.datascience.service.DataScienceService;
import at.tuwien.ss17.dp.lab3.datascience.service.WeatherService;

@Service(value = "dataScienceService")
public class DataScienceServiceImpl implements DataScienceService {

	private static final Logger logger = LoggerFactory.getLogger(DataScienceServiceImpl.class);

	@Autowired
	private RestTemplate restTemplate;
<<<<<<< HEAD

=======
	
>>>>>>> 82d8c4ba981a459f9b1136db32ac23b0012bab6e
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

<<<<<<< HEAD
		List<Weather> weatherList = new ArrayList<Weather>();
		if (result==null) return weatherList;
		String[] list = result.split("\n");
=======
		String[] list = result.split("\n");
		List<Weather> weatherList = new ArrayList<Weather>();
>>>>>>> 82d8c4ba981a459f9b1136db32ac23b0012bab6e

		if (list == null || list.length == 0)
			new ArrayList<Weather>();

		for (int line = 0; line < list.length; line++) {
			logger.info("Line " + line);
			logger.info(list[line]);
			String[] columns = list[line].split(";");
<<<<<<< HEAD
			Weather weather = new Weather(columns[0], columns[1], columns[3], columns[4], columns[5], columns[6],
					columns[7]);
=======
			Weather weather = new Weather(columns[0], columns[1], columns[3], columns[4],columns[5], columns[6], columns[7]);
>>>>>>> 82d8c4ba981a459f9b1136db32ac23b0012bab6e
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

<<<<<<< HEAD
	@Override
	public Data getApiData() {
		List<Weather> all = weatherService.findAll();
		return parseWeatherToApi(all);
	}

	private Data parseWeatherToApi(List<Weather> all) {
		Set<String> series = new HashSet<>();
		Set<String> labels = new HashSet<>();
		List<BigDecimal[]> data = new ArrayList<>();
		List<Weather> allChannels = parseAllChannelsWeatherList(getAllChannels());

		for (Weather weather : allChannels) {
			series.add(weather.getCity());
			List<Weather> dayInfos = parseStringToWeatherList(
					getWeatherByChannel(weather.getChannel().toString()));
			BigDecimal[] temperatures = new BigDecimal[dayInfos.size()];
			int i =0;
			for(Weather singleDayInfo:dayInfos){
				labels.add(singleDayInfo.getDateForecastTimeFormated());
				temperatures[i]=singleDayInfo.getTemperature();
				i++;
			}
			data.add(temperatures);
		}
		List<String > sorted=new ArrayList(labels);
		sorted.sort(String::compareToIgnoreCase);
		return new Data(new ArrayList(series),sorted,data);
	}


	private List<Weather> parseAllChannelsWeatherList(String result) {

		List<Weather> weatherList = new ArrayList<Weather>();
		if (result==null)
			return weatherList;
		String[] list = result.split("\n");

		if (list == null || list.length == 0)
			new ArrayList<Weather>();

		for (int line = 0; line < list.length; line++) {
			logger.info("Line " + line);
			logger.info(list[line]);
			String[] columns = list[line].split(";");
			Weather weather = new Weather(columns[0], columns[1]);
			weatherList.add(weather);
		}
		logger.info(Arrays.deepToString(weatherList.toArray()));
		return weatherList;
	}
=======
>>>>>>> 82d8c4ba981a459f9b1136db32ac23b0012bab6e
}
