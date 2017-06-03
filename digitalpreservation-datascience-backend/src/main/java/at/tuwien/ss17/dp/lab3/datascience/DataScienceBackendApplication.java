package at.tuwien.ss17.dp.lab3.datascience;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DataScienceBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataScienceBackendApplication.class, args);
	}

	@RequestMapping("/hello")
	public String hello(final HttpServletRequest request) {
		return "Hello world! I'm  Data Science Backend ";
	}
}
