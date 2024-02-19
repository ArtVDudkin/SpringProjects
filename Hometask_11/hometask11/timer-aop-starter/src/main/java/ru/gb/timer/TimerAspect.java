package ru.gb.timer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Slf4j
@Aspect
@Component
public class TimerAspect {


    public TimerAspect(TimerProperties properties) {
    }

    @Pointcut("within(@ru.gb.timer.Timer *)")
    public void beansAnnotatedWithTimer() {
    }

    @Pointcut("@annotation(ru.gb.timer.Timer)")
    public void methodsAnnotatedWithTimer() {
    }

    @Around("beansAnnotatedWithTimer() " +
            "|| methodsAnnotatedWithTimer()")
    public Object aroundMethodsPointcut(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println(joinPoint.getTarget().getClass()
                .isAnnotationPresent(Timer.class));
        try {
            if (joinPoint.getTarget().getClass()
                    .isAnnotationPresent(Timer.class) ||
                    method.isAnnotationPresent(Timer.class)) {
                long start = System.currentTimeMillis();
                Object result = joinPoint.proceed();
                long duration = System.currentTimeMillis() - start;
                log.info("Время выполнения метода {} " +
                        " {} милисекунд", method.getName(), duration);
                return result;
            } else {
                Object result = joinPoint.proceed();
                return result;
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

}
