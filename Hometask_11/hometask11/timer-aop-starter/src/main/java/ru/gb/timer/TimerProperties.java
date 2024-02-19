package ru.gb.timer;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("application.timer")
public class TimerProperties {

    /**
     * Включить|выключить таймер выполнения метода или бина
     */
    private boolean onTimer = false;

}