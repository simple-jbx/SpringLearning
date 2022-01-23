package tech.snnukf.service;

import tech.snnukf.dao.StudentDao;
import tech.snnukf.dao.UserDao;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author simple.jbx
 * @ClassName UserService
 * @description 构造器注入 需要提供带参构造器
 * @email jb.xue@qq.com
 * @github https://github.com/simple-jbx
 * @date 2022/01/07/ 18:48
 */
public class UserService02 {

    //构造器注入
    private UserDao userDao;
    private StudentDao studentDao;
    private String name;
    UserService02(UserDao userDao, StudentDao studentDao, String name) {
        this.userDao = userDao;
        this.studentDao = studentDao;
        this.name = name;
    }

    public void test() {
        userDao.test();
        studentDao.test();
        System.out.println(name);
        System.out.println("UserService02 test...");
   }
}
