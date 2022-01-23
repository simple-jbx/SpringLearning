package tech.snnukf.factory;

import tech.snnukf.dao.TypeDao;

/**
 * @author simple.jbx
 * @ClassName InstanceFactory
 * @description //TODO
 * @email jb.xue@qq.com
 * @github https://github.com/simple-jbx
 * @date 2022/01/08/ 18:54
 */
public class InstanceFactory {
    public TypeDao createTypeDao() {
        return new TypeDao();
    }
}
