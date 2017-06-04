package at.tuwien.ss17.dp.lab3.datascience.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
<<<<<<< HEAD
<<<<<<< HEAD
import java.time.format.DateTimeFormatter;
=======
>>>>>>> 82d8c4ba981a459f9b1136db32ac23b0012bab6e
=======
import java.time.format.DateTimeFormatter;
>>>>>>> bc488855ecbfb873257992d1dec817bbfac4a278

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import at.tuwien.ss17.sp.lab3.datascience.constants.Constants;

@Document(collection = "weather")
public class Weather implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2553737118461848605L;

	@Id
	private Long channel;

	private String city;

	private LocalDateTime dateForecast;

	private BigDecimal temperature;

	private String unit;

	private LocalDateTime timestamp;
	
	public Weather(){}

	public Weather(Long channel, String city, LocalDateTime dateForecast, BigDecimal temperature, String unit,
			LocalDateTime timestamp) {
		this.channel = channel;
		this.city = city;
		this.dateForecast = dateForecast;
		this.temperature = temperature;
		this.unit = unit;
		this.timestamp = timestamp;
	}

	public Weather(String channel, String city, String dateForecast, String hourForecast, String temperature, String unit,
			String timestamp) {
		this.channel = Long.valueOf(channel.replace("'", ""));
		this.city = city.replace("'", "");
		String dateHourForecast = dateForecast.replace("'", "") + " "+hourForecast.replace("'", "");
		this.dateForecast = LocalDateTime.parse(dateHourForecast, Constants.formatter1);
		this.temperature = new BigDecimal(temperature.replace("'", ""));
		this.unit = unit.replace("'", "");
		this.timestamp = LocalDateTime.parse(timestamp.replace("'", ""), Constants.formatter2);
	}
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> bc488855ecbfb873257992d1dec817bbfac4a278
	public Weather(String channel, String city){
		this.channel = Long.valueOf(channel.replace("'", ""));
		this.city = city.replace("'", "");
	}
<<<<<<< HEAD
=======
>>>>>>> 82d8c4ba981a459f9b1136db32ac23b0012bab6e
=======
>>>>>>> bc488855ecbfb873257992d1dec817bbfac4a278

	public Long getChannel() {
		return channel;
	}

	public String getCity() {
		return city;
	}

	public String getDateForecast() {
		return dateForecast.toString();
	}
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> bc488855ecbfb873257992d1dec817bbfac4a278
	public String getDateForecastTimeFormated() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		return dateForecast.format(formatter);
	}
<<<<<<< HEAD
=======
>>>>>>> 82d8c4ba981a459f9b1136db32ac23b0012bab6e
=======
>>>>>>> bc488855ecbfb873257992d1dec817bbfac4a278

	public BigDecimal getTemperature() {
		return temperature;
	}

	public String getUnit() {
		return unit;
	}

	public String getTimestamp() {
		return timestamp.toString();
	}

}
