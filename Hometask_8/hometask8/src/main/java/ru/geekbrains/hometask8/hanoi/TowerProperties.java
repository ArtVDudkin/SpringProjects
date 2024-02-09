package ru.geekbrains.hometask8.hanoi;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("application.tower")
@Data
public class TowerProperties {

    //a count of disks to replace:
    private int disksQty = 3;

}
