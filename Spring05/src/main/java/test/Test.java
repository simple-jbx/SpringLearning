package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tech.snnukf.dao.UserDao;
import tech.snnukf.service.UserService;

/**
 * @author simple.jbx
 * @ClassName Test
 * @description //TODO
 * @email jb.xue@qq.com
 * @github https://github.com/simple-jbx
 * @date 2022/02/21/ 14:49
 */
public class Test {
    public static void main(String[] args) {
        //获取上下文环境
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring02.xml");
        UserService userService = (UserService) ac.getBean("userService");
        userService.test();
//
//        UserDao userDao = (UserDao) ac.getBean("userDao");
//        userDao.test();
    }
}
