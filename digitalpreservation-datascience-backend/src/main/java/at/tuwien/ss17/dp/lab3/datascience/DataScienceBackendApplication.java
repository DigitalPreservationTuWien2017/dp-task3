package at.tuwien.ss17.dp.lab3.datascience;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

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
	
	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/getApiData").allowedOrigins("http://localhost:8000");
            }
        };
    }
}
