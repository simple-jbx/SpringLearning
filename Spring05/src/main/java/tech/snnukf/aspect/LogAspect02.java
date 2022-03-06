package tech.snnukf.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component //将对象交给IOC进行实例化
public class LogAspect02 {
    public void cut(){}

    public void before(){
        System.out.println("before notification");
    }

    public void afterReturn(){
        System.out.println("afterReturn notification");
    }

    public void after() {
        System.out.println("after notification");
    }

    public void afterThrow(Exception e) {
        System.out.println("=====Throw notification=====");
        System.out.println(e.getMessage());
    }


    public Object around(ProceedingJoinPoint pjp) {
        System.out.println("around after notification");
        Object object = null;

        try {
            //显示调用对应的方法
            object = pjp.proceed();
            System.out.println(pjp.getTarget());
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("around-error notification");
        } finally {
            System.out.println("around-finally notification");
        }

        return object;
    }
}
