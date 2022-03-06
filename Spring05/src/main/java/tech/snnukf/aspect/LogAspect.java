package tech.snnukf.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author simple.jbx
 * @ClassName LogAspect
 * @description 切面
 * 切入点和通知的抽象
 *      切入点：定义要拦截哪些类和哪些方法
 *      通知：定义了拦截之后方法要做什么
 * @email jb.xue@qq.com
 * @github https://github.com/simple-jbx
 * @date 2022/02/21/ 14:27
 */
@Component //将对象交给IOC进行实例化
@Aspect //声明当前类是一个切面
public class LogAspect {

    /**
     * @author simple.jbx
     * @description 切入点
     *      定义要拦截哪些类的哪些方法
     *      匹配规则，拦截什么方法
     *      定义切入点
     *      @Pointcut("匹配规则")
     *
     *      AOP切入点表达式
     *          1.执行所有的公共方法
     *              execution(public *(..))
     *          2.执行任意的set方法
     *              execution(* set*(..))
     *          3.设置指定包下的任意类的任意方法（指定包tech.snnukf.service）
     *              execution(* tech.snnukf.*.*(..))
     *          4.设置指定包及子包下的任意类的任意方法（指定包tech.snnukf.service）
     *              exectuion(* tech.snnukf.service..*.*(..))
     *          5.第一个 * 表示修饰范围（public private protected *表示所有范围）
     * @date 14:29 2022/2/21
     * @param
     * @return
     **/
    @Pointcut("execution(* *(..))")
    public void cut() {

    }

    /**
     * @author simple.jbx
     * @description 声明前置同志，并将同志应用到指定的切入点上
     *  目标类方法执行前，执行该通知
     * @date 14:38 2022/2/21
     * @param
     * @return
     **/
    @Before(value = "cut()")
    public void before() {
        System.out.printf("before notification");
    }

    @AfterReturning(value = "cut()")
    public void afterReturning() {
        System.out.println("afterReturning notification");
    }

    /**
     * @author simple.jbx
     * @description 最终通知 有无异常都会执行该通知
     * @date 14:40 2022/2/21
     * @param
     * @return
     **/
    @After(value = "cut()")
    public void after() {
        System.out.println("after notification");
    }

    /**
     * @author simple.jbx
     * @description 异常通知
     * @date 14:42 2022/2/21
     * @param
     * @return
     **/
    @AfterThrowing(value = "cut()", throwing = "e")
    public void afterThrow(Exception e) {
        System.out.println("throw notification");
        System.out.println("===== throw message =====");
        System.out.println(e.getMessage());
    }

    /**
     * @author simple.jbx
     * @description 环绕通知，目标类方法执行前后，都可以使用（需要显示调用 pjp.processed()）
     * @date 14:42 2022/2/21
     * @param
     * @return
     **/
    @Around(value = "cut()")
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
