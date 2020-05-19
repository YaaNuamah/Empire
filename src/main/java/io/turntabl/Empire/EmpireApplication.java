package io.turntabl.Empire;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.security.Timestamp;
import java.sql.Date;
import java.text.SimpleDateFormat;

@EnableSwagger2
@SpringBootApplication
public class EmpireApplication {

	public static void main(String[] args) { SpringApplication.run(EmpireApplication.class, args);

	}

}
