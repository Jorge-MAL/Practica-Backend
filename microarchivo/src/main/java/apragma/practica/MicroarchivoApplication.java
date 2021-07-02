package apragma.practica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableEurekaClient
@EnableDiscoveryClient
@EnableSwagger2
@SpringBootApplication
public class MicroarchivoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroarchivoApplication.class, args);
	}

}
