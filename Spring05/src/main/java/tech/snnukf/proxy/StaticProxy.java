package tech.snnukf.proxy;

/**
 * @author simple.jbx
 * @ClassName StaticProxy
 * @description //TODO
 * @email jb.xue@qq.com
 * @github https://github.com/simple-jbx
 * @date 2022/02/17/ 16:55
 */
public class StaticProxy {
    public static void main(String[] args) {
        //目标对象
        You you = new You();
        //代理对象
        MarryCompanyProxy marryCompanyProxy = new MarryCompanyProxy(you);

        //通过代理对象调用目标对象中的方法
        marryCompanyProxy.toMarry();
    }
}
