package com.company.osproject;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "OS Project",
				version = "1 - version",
				description = "Operating System Team 14",
				license = @License(
						name = "Abduali Abdumutalibov"
				)
		),
		servers = @Server(
				url = "http://localhost:8003"
		)
)
public class OsprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(OsprojectApplication.class, args);
	}

}
