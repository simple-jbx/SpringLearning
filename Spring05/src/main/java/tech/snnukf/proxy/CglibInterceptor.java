package tech.snnukf.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author simple.jbx
 * @ClassName CglibInterceptor
 * @description //TODO
 * @email jb.xue@qq.com
 * @github https://github.com/simple-jbx
 * @date 2022/02/19/ 14:23
 */
public class CglibInterceptor implements MethodInterceptor {

    //目标对象
    private Object target;

    public CglibInterceptor(Object target) {
        this.target = target;
    }

    /**
     * @author simple.jbx
     * @description 获取代理对象
     * @date 14:24 2022/2/19
     * @param
     * @return
     **/
    public Object getProxy() {
        //通过Enhancer对象中的create()方法生成一个类，用于生成代理对象
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());

        //设置拦截器  回调对象为自己
        enhancer.setCallback(this);

        //生成代理类对象，并返回给调用者
        return enhancer.create();
    }

    /**
     * @author simple.jbx
     * @description 拦截器
     * 1. 目标对象的方法调用
     * 2. 行为增强
     * @date 14:29 2022/2/19
     * @param	o CGLIB动态生成的代理类实例
     * @param	method 实体类中所调用的被代理的方法的引用
     * @param	objects 参数列表
     * @param	methodProxy 生成的代理类对方法的代理引用
     * @return
     **/
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        //增强行为
        System.out.println("====after====");

        //调用目标类中的方法
        Object object = methodProxy.invoke(target, objects);

        //增强行为
        System.out.println("====before====");

        return object;
    }
}
