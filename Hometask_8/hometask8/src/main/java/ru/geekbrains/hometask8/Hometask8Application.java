package ru.geekbrains.hometask8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import ru.geekbrains.hometask8.hanoi.HanoiTower;
import ru.geekbrains.hometask8.hanoi.TowerProperties;

@SpringBootApplication
@EnableConfigurationProperties(TowerProperties.class)
public class Hometask8Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Hometask8Application.class, args);

		HanoiTower tower = new HanoiTower();
		tower.start();
	}

}
