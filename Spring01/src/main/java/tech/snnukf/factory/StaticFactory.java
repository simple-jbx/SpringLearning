package tech.snnukf.factory;

import tech.snnukf.service.TypeService;

/**
 * @author simple.jbx
 * @ClassName StaticFactory
 * @description 定义静态工厂
 * @email jb.xue@qq.com
 * @github https://github.com/simple-jbx
 * @date 2022/01/04/ 21:27
 */
public class StaticFactory {
    public static TypeService createTypeService() {
        return new TypeService();
    }
}
