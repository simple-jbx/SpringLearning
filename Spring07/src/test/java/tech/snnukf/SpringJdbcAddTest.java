package tech.snnukf;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tech.snnukf.dao.IAccountDao;
import tech.snnukf.entity.Account;

import java.util.ArrayList;
import java.util.List;

/**
 * 账户模块添加测试类
 *
 * @className: SpringJdbcAddTest
 * @author: simple.jbx
 * @date: 2022/12/20
 **/
public class SpringJdbcAddTest extends BaseTest{

    @Autowired
    private IAccountDao accountDao;

    @Test
    public void testAddAccount01() {
        // 准备添加的数据
        Account account = Account
                .builder()
                .name("account3")
                .type("工商银行")
                .money(500.0)
                .remark("reward")
                .userId(1)
                .build();

        int row = accountDao.addAccount(account);
        System.out.println("add account, affect rows : " + row);
    }

    @Test
    public void testAddAccount02() {
        // 准备添加的数据
        Account account = Account
                .builder()
                .name("account3")
                .type("中国银行")
                .money(5000.0)
                .remark("salary")
                .userId(1)
                .build();

        int key = accountDao.addAccountHasKey(account);
        System.out.println("add account, key = " + key);
    }

    @Test
    public void testBatchAddAccount() {
        Account account0 = Account
                .builder()
                .name("account3")
                .type("中国银行")
                .money(15000.0)
                .remark("salary")
                .userId(1)
                .build();
        Account account1 = Account
                .builder()
                .name("account3")
                .type("农业银行")
                .money(10000.0)
                .remark("salary")
                .userId(1)
                .build();
        Account account2 = Account
                .builder()
                .name("account3")
                .type("工商银行")
                .money(6000.0)
                .remark("salary")
                .userId(1)
                .build();

        List<Account> accounts = new ArrayList<>();
        accounts.add(account0);
        accounts.add(account1);
        accounts.add(account2);

        int rows = accountDao.addAccountBatch(accounts);
        System.out.println(rows);
    }

    @Test
    public void queryAccountCount() {
        int count = accountDao.queryAccountCount(1);
        System.out.println(count);
    }


}
