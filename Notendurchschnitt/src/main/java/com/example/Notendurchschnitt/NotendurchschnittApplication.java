package com.example.Notendurchschnitt;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Notendurchschnitt.service.CalcAvg;

@SpringBootApplication
public class NotendurchschnittApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotendurchschnittApplication.class, args);
	}

	@Bean
	CommandLineRunner init() {
		CommandLineRunner action = new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				CalcAvg calcAvg = new CalcAvg();

				calcAvg.getDurchschnitt();
			}
		};
		return action;
	}
	
}
