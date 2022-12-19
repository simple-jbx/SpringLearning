package tech.snnukf;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
public class SpringTestJDBC3 extends BaseTest{

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
