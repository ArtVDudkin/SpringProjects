package ru.geekbrains.hometask8.hanoi;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
@Data
@Timer
public class HanoiTower {

    private final int with = 1;
    private final int on = 3;
    private final int some = 2;

    @Autowired
    private final TowerProperties towerProperties = new TowerProperties();
    //a count of disks to replace:
    private int disksQty;

    public HanoiTower() {
        this.disksQty = this.towerProperties.getDisksQty();
    }

//    @Timer
    public void start() {
        replaceTower(with, on, some, disksQty);
    }

    @RecoverException(noRecoverFor = {IllegalArgumentException.class,
            NoSuchElementException.class})
    private void replaceTower(int with, int on, int some, int count) {
        if (count > 0) {
            replaceTower(with, some, on, count - 1);
            System.out.printf("Move disk %d from %d to %d\n", count, with, on);
            replaceTower(some, on, with, count - 1);
        }
    }

}
