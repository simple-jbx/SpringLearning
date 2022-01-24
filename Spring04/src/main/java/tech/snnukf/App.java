package tech.snnukf;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tech.snnukf.service.AccountService;
import tech.snnukf.service.UserService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
//        UserService userService = (UserService) ac.getBean("userService");
//        userService.test();

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = (AccountService) ac.getBean("accountService");
        accountService.test();
    }
}
