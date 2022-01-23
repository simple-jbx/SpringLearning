package tech.snnukf.service;

import tech.snnukf.dao.IUserDao;
import tech.snnukf.dao.UserDao;

import javax.annotation.Resource;

/**
 * @author simple.jbx
 * @ClassName UserService
 * @description //TODO
 * @email jb.xue@qq.com
 * @github https://github.com/simple-jbx
 * @date 2022/01/23/ 16:39
 */
public class UserService {

    //注入JavaBean对象
    //@Resource(name = "userDao")
    @Resource
    private UserDao userDao;

    //@Resource
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    //注入接口
    @Resource(name = "userDaoImpl02")
    private IUserDao iUserDao;


    public void test() {
        userDao.test();
        iUserDao.test();
        System.out.println(UserService.class.getName());
    }
}
