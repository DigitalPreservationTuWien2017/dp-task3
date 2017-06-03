package at.tuwien.ss17.sp.lab3.datascience.constants;

import java.time.format.DateTimeFormatter;

public interface Constants {

	static DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
	static DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
}
