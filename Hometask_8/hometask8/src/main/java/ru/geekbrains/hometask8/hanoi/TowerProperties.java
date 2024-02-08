package ru.geekbrains.hometask8.hanoi;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("application.tower")
public class TowerProperties {

    //a count of disks to replace:
    private int disksQty = 3;

    public int getDisksQty() {
        return disksQty;
    }

    public void setDisksQty(int disksQty) {
        this.disksQty = disksQty;
    }

}
