package at.tuwien.ss17.dp.lab3.datascience.config;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.not;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo()).select().apis(RequestHandlerSelectors.any())
				.paths(getPaths()).build();
	}
	
	private Predicate<String> getPaths(){
		return not(regex("/hello"));
	}

	private ApiInfo getApiInfo() {
		return new ApiInfoBuilder().title("DP Task 3 - Backend API").description("DP Task 3 Backend API Documentation.")
				.contact(new Contact("DP Task 3", "", "")).license("Apache")
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0").build();
	}
}
