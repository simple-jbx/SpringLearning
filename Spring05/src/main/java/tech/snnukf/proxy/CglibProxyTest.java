package tech.snnukf.proxy;

/**
 * @author simple.jbx
 * @ClassName CglibProxyTest
 * @description //TODO
 * @email jb.xue@qq.com
 * @github https://github.com/simple-jbx
 * @date 2022/02/19/ 14:34
 */
public class CglibProxyTest {
    public static void main(String[] args) {
        //目标对象
        You you = new You();

        //拦截器
        CglibInterceptor cglibInterceptor = new CglibInterceptor(you);

        //代理对象
        Marry marry = (Marry) cglibInterceptor.getProxy();

        marry.toMarry();

        //没有接口实现的类
        User user = new User();
        CglibInterceptor cglibInterceptor2 = new CglibInterceptor(user);
        User newUser = (User) cglibInterceptor2.getProxy();
        newUser.test();
    }
}
