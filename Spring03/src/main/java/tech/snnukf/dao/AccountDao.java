package tech.snnukf.dao;

import tech.snnukf.service.AccountService;

/**
 * @author simple.jbx
 * @ClassName AccountDao
 * @description 构造器注入出现循环依赖问题
 * @email jb.xue@qq.com
 * @github https://github.com/simple-jbx
 * @date 2022/01/08/ 17:19
 */
public class AccountDao {

    private AccountService accountService;

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }
    //    public AccountDao(AccountService accountService) {
//        this.accountService = accountService;
//    }

    public void test() {
        System.out.println(AccountDao.class.getName());
    }
}
