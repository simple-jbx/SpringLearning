package tech.snnukf.factory;

import tech.snnukf.dao.TypeDao;

/**
 * @author simple.jbx
 * @ClassName StaticFactory
 * @description 静态工厂
 * @email jb.xue@qq.com
 * @github https://github.com/simple-jbx
 * @date 2022/01/08/ 18:47
 */
public class StaticFactory {
//    定义静态方法
    public static TypeDao createTypeDao() {
        return new TypeDao();
    }
}
