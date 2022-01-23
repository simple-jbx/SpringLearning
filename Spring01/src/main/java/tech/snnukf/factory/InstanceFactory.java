package tech.snnukf.factory;

import tech.snnukf.controller.TypeController;
import tech.snnukf.service.UserService;

/**
 * @author simple.jbx
 * @ClassName InstanceFactory
 * @description 定义实例化工厂
 * @email jb.xue@qq.com
 * @github https://github.com/simple-jbx
 * @date 2022/01/04/ 22:32
 */
public class InstanceFactory {
   public TypeController createTypeController() {
       return new TypeController();
   }
}
