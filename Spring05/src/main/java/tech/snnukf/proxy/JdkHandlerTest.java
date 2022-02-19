package tech.snnukf.proxy;

/**
 * @author simple.jbx
 * @ClassName JdkHandlerTest
 * @description //TODO
 * @email jb.xue@qq.com
 * @github https://github.com/simple-jbx
 * @date 2022/02/18/ 1:02
 */
public class JdkHandlerTest {
    public static void main(String[] args) {

        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        //目标对象
        You you = new You();

        //得到代理类
        JdkHandler jdkHandler = new JdkHandler(you);
        Marry marry = (Marry) jdkHandler.getProxy();

        //通过代理调用目标对象的方法
        marry.toMarry();
    }
}
