package net.java.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringbootCrudGliApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCrudGliApplication.class, args);
	}

}
