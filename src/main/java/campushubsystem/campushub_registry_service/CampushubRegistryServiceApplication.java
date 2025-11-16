package campushubsystem.campushub_registry_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
@EnableEurekaServer
@SpringBootApplication
public class CampushubRegistryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CampushubRegistryServiceApplication.class, args);
	}

}
