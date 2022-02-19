package tech.snnukf.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author simple.jbx
 * @ClassName JdkHandler
 * @description JDK动态代理类
 * 每个代理类都要实现InvocationHandler接口
 * @email jb.xue@qq.com
 * @github https://github.com/simple-jbx
 * @date 2022/02/18/ 0:51
 */
public class JdkHandler implements InvocationHandler{

    //目标对象的类型不固定 创建时动态生成
    private Object target;

    //通过带参构造器传递目标对象
    public JdkHandler(Object target) {
        this.target = target;
    }

    /**
     * @author simple.jbx
     * @description
     * 1.调用目标对象的防范（返回Object）
     * 2.增强目标对象的行为
     * @date 0:59 2022/2/18
     * @param	proxy 调用该方法的实例
     * @param	method 目标对象方法
     * @param	args 目标对象方法所需要的参数
     * @return 
     **/
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("invoke method parmar ==> " + proxy.getClass().getName());

        //用户的增强行为
        System.out.println("====invoke before====");

        //调用目标对象中的方法
        Object object = method.invoke(target, args);

        //用户的增强行为
        System.out.println("====invoke after====");

        return object;
    }

    /**
     * @author simple.jbx
     * @description 获取代理对象
     * public static Object newProxyInstance(ClassLoader loader,
     *                                           Class<?>[] interfaces,
     *                                           InvocationHandler h)
     *
     *  loader 类加载器
     *  interfaces 接口数组
     *  h InvocationHandler接口（传入该接口的实现类）
     * @date 0:53 2022/2/18
     * @param
     * @return
     **/
    public Object getProxy() {
        Object object = Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(), this);

        System.out.println("getProxy return proxy object ==> " + object.getClass().getName());
        return object;
    }
}
