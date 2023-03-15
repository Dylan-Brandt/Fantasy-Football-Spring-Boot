package com.football;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class FootballStatsApplication {

	public static void main(String[] args) {

		SpringApplication.run(FootballStatsApplication.class, args);
		
	}

}
