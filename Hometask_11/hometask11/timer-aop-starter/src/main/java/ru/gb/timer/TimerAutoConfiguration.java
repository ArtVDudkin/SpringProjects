package ru.gb.timer;

import ru.gb.timer.TimerAspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(TimerProperties.class)
@ConditionalOnProperty(value = "application.timer.enabled", havingValue = "true")
public class TimerAutoConfiguration {

    @Bean
    TimerAspect timingAspect(TimerProperties properties) {
        return new TimerAspect(properties);
    }

}