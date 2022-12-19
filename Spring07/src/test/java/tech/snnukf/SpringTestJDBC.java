package tech.snnukf;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * TODO...
 *
 * @className: SpringTestJDBC
 * @author: simple.jbx
 * @date: 2022/12/18
 **/
public class SpringTestJDBC {

    private static ApplicationContext ac;

    private static JdbcTemplate jdbcTemplate;


    @Before
    public void init() {
        //获取spring上下文环境
        ac = new ClassPathXmlApplicationContext("spring.xml");
        //得到模板类
        jdbcTemplate = (JdbcTemplate) ac.getBean("jdbcTemplate");
    }

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
