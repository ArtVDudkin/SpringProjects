package ru.geekbrains.hometask7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ReaderProperties.class)
public class Hometask7Application {

	public static void main(String[] args) {
		SpringApplication.run(Hometask7Application.class, args);
	}

}
