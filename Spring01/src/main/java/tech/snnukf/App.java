package main.java.tech.snnukf;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tech.snnukf.dao.TypeDao;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring02.xml");
        TypeDao typeDao = (TypeDao) beanFactory.getBean("typeDao");
        typeDao.test();
    }
}
