package io.turntabl.Empire;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import io.turntabl.Empire.Controllers.EndpointController;

@EnableSwagger2
@SpringBootApplication
public class EmpireApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpireApplication.class, args);

		String endpointUrl = "http://localhost:8080/api/v1/endpoints";
		String url = endpointUrl;



	}

}
