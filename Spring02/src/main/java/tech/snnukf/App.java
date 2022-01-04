package tech.snnukf;

import tech.snnukf.dao.UserDao;
import tech.snnukf.service.UserService;
import tech.snnukf.spring.MyClassPathXmalApplicationContext;
import tech.snnukf.spring.MyFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //得到工厂实现
        MyFactory myFactory = new MyClassPathXmalApplicationContext("spring.xml");
        //得到对应的实例化对象
        UserDao userDao = (UserDao) myFactory.getBean("userDao");
        userDao.test();

        UserDao userDao02 = (UserDao) myFactory.getBean("userDao");
        userDao02.test();

        System.out.println(userDao == userDao02);

        UserService userService = (UserService) myFactory.getBean("userService");
        userService.test();
    }
}
