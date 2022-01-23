package tech.snnukf.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tech.snnukf.controller.TypeController;
import tech.snnukf.dao.TypeDao;
import tech.snnukf.service.TypeService;

/**
 * IOC 容器 Bean 对象的实例化方式
 * 1. 构造器实例化
 *      bean对象需要提供空构造函数
 * 2. 静态工厂实例化（了解）
 * 3. 实例化工厂实例化（了解）
 * @author simple.jbx
 * @ClassName Start02
 * @description //TODO
 * @email jb.xue@qq.com
 * @github https://github.com/simple-jbx
 * @date 2022/01/04/ 20:15
 */
public class Start02 {
    public static void main( String[] args )
    {
        //构造器实例化
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring02.xml");
        TypeDao typeDao = (TypeDao) beanFactory.getBean("typeDao");
        typeDao.test();

        //静态工厂实例化
        TypeService typeService = (TypeService) beanFactory.getBean("typeService");
        typeService.test();

        //实例化工厂实例化
        TypeController typeController = (TypeController) beanFactory.getBean("typeController");
        typeController.test();
    }
}
