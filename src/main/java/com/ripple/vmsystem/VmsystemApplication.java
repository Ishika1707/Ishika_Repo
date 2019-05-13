package com.ripple.vmsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.ripple.vmsystem")
public class VmsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(VmsystemApplication.class, args);
	}

}
