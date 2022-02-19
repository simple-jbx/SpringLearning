package tech.snnukf.proxy;

/**
 * @author simple.jbx
 * @ClassName MarryCompanyProxy
 * @description 静态代理->代理角色
 * 1.实现行为 2.增强用户行为
 * @email jb.xue@qq.com
 * @github https://github.com/simple-jbx
 * @date 2022/02/17/ 16:49
 */
public class MarryCompanyProxy implements Marry{
    //目标对象
    private Marry target;

    //通过带参构造传递目标对象
    public MarryCompanyProxy(Marry target) {
        this.target = target;
    }

    @Override
    public void toMarry() {
        //用户行为增强
        before();

        target.toMarry();

        //用户行为增强
        after();
    }

    private void before() {
        System.out.println("In preparation ...");
    }

    private void after() {
        System.out.println("Finish ...");
    }
}
