package tech.snnukf;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * TODO...
 *
 * @className: BaseTest
 * @author: simple.jbx
 * @date: 2022/12/19
 **/
//将测试运行在Spring测试环境中
@RunWith(SpringJUnit4ClassRunner.class)
//测试要加载的配置文件
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class BaseTest {
}
