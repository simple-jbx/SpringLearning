package tech.snnukf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import tech.snnukf.dao.AccountDao;

/**
 * @author simple.jbx
 * @ClassName UserService02
 * @description //TODO
 * @email jb.xue@qq.com
 * @github https://github.com/simple-jbx
 * @date 2022/01/23/ 17:40
 */
public class AccountService {

    @Autowired
    @Qualifier(value = "accountDao") //需要的时候可结合使用
    private AccountDao accountDao;

    public void test() {
        accountDao.test();
        System.out.printf(AccountService.class.getName());
    }
}
