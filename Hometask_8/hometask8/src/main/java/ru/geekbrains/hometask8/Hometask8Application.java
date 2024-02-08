package ru.geekbrains.hometask8;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import ru.geekbrains.hometask8.hanoi.HanoiTower;
import ru.geekbrains.hometask8.hanoi.TowerProperties;

@Slf4j
@SpringBootApplication
@EnableConfigurationProperties(TowerProperties.class)
public class Hometask8Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Hometask8Application.class, args);

		HanoiTower tower = new HanoiTower();
		tower.start();
	}

}
