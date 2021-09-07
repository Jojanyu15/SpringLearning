package co.s4n.springbootapp.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
@EnableDiscoveryClient

public class SpringbootServiceEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServiceEurekaServerApplication.class, args);
	}

}
