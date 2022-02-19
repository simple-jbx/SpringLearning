package tech.snnukf.proxy;

/**
 * @author simple.jbx
 * @ClassName You
 * @description 静态代理->目标角色 实现行为
 * @email jb.xue@qq.com
 * @github https://github.com/simple-jbx
 * @date 2022/02/17/ 16:48
 */
public class You implements Marry{
    @Override
    public void toMarry() {
        System.out.println("I'll marry ...");
    }
}
