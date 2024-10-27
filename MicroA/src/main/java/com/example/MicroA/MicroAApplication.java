package com.example.MicroA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MicroAApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroAApplication.class, args);
	}

}
