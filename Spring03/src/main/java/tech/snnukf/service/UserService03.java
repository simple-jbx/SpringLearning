package tech.snnukf.service;

import tech.snnukf.dao.StudentDao;
import tech.snnukf.dao.UserDao;

/**
 * @author simple.jbx
 * @ClassName UserService
 * @description 构造器注入 需要提供带参构造器
 * @email jb.xue@qq.com
 * @github https://github.com/simple-jbx
 * @date 2022/01/07/ 18:48
 */
public class UserService03 {

    private UserDao userDao;
    private String name;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void test() {
        userDao.test();
        System.out.println(name);
        System.out.println(UserService03.class.getName());
    }
}
