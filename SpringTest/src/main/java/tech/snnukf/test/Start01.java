package tech.snnukf.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import tech.snnukf.service.UserService;
import tech.snnukf.service.UserService02;

public class Start01 {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");

        // 通过id拿到指定bean对象
        UserService  userService = (UserService) ac.getBean("userService");
        userService.test();

        UserService02 userService02 = (UserService02) ac.getBean("userService02");
        userService02.test();

    }
}
