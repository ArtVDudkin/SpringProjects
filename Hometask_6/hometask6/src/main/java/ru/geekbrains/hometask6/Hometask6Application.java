package ru.geekbrains.hometask6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ReaderProperties.class)
public class Hometask6Application {

	public static void main(String[] args) {
		SpringApplication.run(Hometask6Application.class, args);
	}

}
