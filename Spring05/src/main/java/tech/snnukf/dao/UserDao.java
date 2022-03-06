package tech.snnukf.dao;

import org.springframework.stereotype.Repository;

/**
 * @author simple.jbx
 * @ClassName UserDao
 * @description //TODO
 * @email jb.xue@qq.com
 * @github https://github.com/simple-jbx
 * @date 2022/02/21/ 14:24
 */
@Repository
public class UserDao {
    public void test() {
        System.out.println(UserDao.this.getClass().getName());
    }
}
