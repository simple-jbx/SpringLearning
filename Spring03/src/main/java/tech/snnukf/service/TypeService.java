package tech.snnukf.service;

import tech.snnukf.dao.TypeDao;

/**
 * @author simple.jbx
 * @ClassName TypeService
 * @description //TODO
 * @email jb.xue@qq.com
 * @github https://github.com/simple-jbx
 * @date 2022/01/08/ 18:49
 */
public class TypeService {
    //注入TypeDao
    private TypeDao typeDao;

    public void setTypeDao(TypeDao typeDao) {
        this.typeDao = typeDao;
    }

    public void test() {
        System.out.println(TypeService.class.getName());
    }
}
