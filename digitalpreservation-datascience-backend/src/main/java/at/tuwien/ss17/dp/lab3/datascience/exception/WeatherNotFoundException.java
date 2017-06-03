package at.tuwien.ss17.dp.lab3.datascience.exception;

public class WeatherNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -550665932027844595L;

	public WeatherNotFoundException(String id) {
		super(id);
	}

}
