package tech.snnukf;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tech.snnukf.task.TaskJob;

/**
 * Hello world!
 *
 */
public class Test
{
    public static void main( String[] args )
    {
        System.out.println( "测试定时任务！" );

        //获取Spring上下文环境
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        //获取指定bean对象
        TaskJob taskJob = (TaskJob) ac.getBean("taskJob");
    }
}
