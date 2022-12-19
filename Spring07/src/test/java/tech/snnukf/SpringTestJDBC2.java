package tech.snnukf;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * TODO...
 *
 * @className: SpringTestJDBC
 * @author: simple.jbx
 * @date: 2022/12/18
 **/
//将测试运行在Spring测试环境中
@RunWith(SpringJUnit4ClassRunner.class)
//测试要加载的配置文件
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class SpringTestJDBC2 {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testJdbc01() {
        //crud
        //定义sql语句
        String sql = "select count(*) from t_account";
        //执行查询操作（无参数）
        Integer total = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println("total = " + total);
    }

    @Test
    public void testJdbc02() {
        //crud
        //定义sql语句
        String sql = "select count(*) from t_account where user_id = ?";
        //执行查询操作（无参数）
        Integer total = jdbcTemplate.queryForObject(sql, Integer.class, 1);
        System.out.println("total = " + total);
    }
}
