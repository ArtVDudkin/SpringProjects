package ru.geekbrains.hometask8.hanoi;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class HanoiAspect {

    @Pointcut("within(@ru.geekbrains.hometask8.hanoi.Timer *)")
    public void beansAnnotatedWithTimer() {
    }

    @Pointcut("@annotation(ru.geekbrains.hometask8.hanoi.Timer)")
    public void methodsAnnotatedWithTimer() {
    }

    @Pointcut("@annotation(ru.geekbrains.hometask8.hanoi.RecoverException)")
    public void methodsAnnotatedWithRecoverException() {
    }

    @Around("beansAnnotatedWithTimer() " +
            "|| methodsAnnotatedWithTimer() " +
            "|| methodsAnnotatedWithRecoverException()")
    public Object aroundHanoiTowerMethodsPointcut(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        try {
            if (joinPoint.getTarget().getClass()
                    .isAnnotationPresent(Timer.class) ||
                    method.isAnnotationPresent(Timer.class)) {
                long start = System.currentTimeMillis();
                Object proceed = joinPoint.proceed();
                long finish = System.currentTimeMillis();
                log.info("Время выполнения метода {} " +
                        " {} наносекунд", method.getName().toLowerCase(), finish - start);
                return proceed;
            } else {
                Object proceed = joinPoint.proceed();
                return proceed;
            }
        } catch (Throwable e) {
            if (method.isAnnotationPresent(RecoverException.class)) {
                if (Arrays.stream(method.getAnnotation(RecoverException.class)
                        .noRecoverFor()).anyMatch(it -> e.getClass()
                        .isAssignableFrom(it))) {
                    throw e;
                }
            }
            return null;
        }
    }

}
