package tech.snnukf.service;

import tech.snnukf.dao.AccountDao;

/**
 * @author simple.jbx
 * @ClassName AccountService
 * @description //TODO
 * @email jb.xue@qq.com
 * @github https://github.com/simple-jbx
 * @date 2022/01/08/ 17:19
 */
public class AccountService {
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
//    public AccountService(AccountDao accountDao) {
//        this.accountDao = accountDao;
//    }

    public void test() {
        System.out.println(AccountService.class.getName());
    }
}
