package ru.geekbrains.hometask8.hanoi;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Task {

    @Before("execution(* ru.geekbrains.hometask8.hanoi.HanoiTower.* (..))")
    public void logBeforeTask() {
        System.out.println("we here");
    }
}
