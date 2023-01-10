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
public class SpringJdbcCrudTest extends BaseTest{

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

    @Test
    public void queryAccount() {
        Account account = accountDao.queryAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testDeleteAccount() {
        int row = accountDao.deleteAccount(1);
        System.out.println("delete " + row + " rows");
    }

    @Test
    public void queryAccountByParams() {
        List<Account> accounts = accountDao.queryAccountByParams(1, "acc2", null, null);
        System.out.println("accounts size " + accounts.size());
        accounts.forEach(System.out::println);
    }

    @Test
    public void updateAccountBatch() {
        Account account1 = Account
                .builder()
                .id(6)
                .name("acc5")
                .type("农业银行")
                .money(700.56)
                .remark("奖金")
                .userId(3)
                .build();
        Account account2 = Account
                .builder()
                .id(7)
                .name("acc6")
                .type("建设银行")
                .money(200.00)
                .remark("花费补贴")
                .userId(3)
                .build();
        Account account3 = Account
                .builder()
                .id(8)
                .name("acc7")
                .type("工商银行")
                .money(600.00)
                .remark("交通补贴")
                .userId(3)
                .build();

        List<Account> accounts = new ArrayList<>();
        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);

        int rows = accountDao.updateAccountBatch(accounts);
        System.out.println("updateBatch, affect " + rows + " rows");

    }

    @Test
    public void deleteAccountBatch() {
        List<Integer> accountIds = new ArrayList<>();
        accountIds.add(1);
        accountIds.add(7);
        int rows = accountDao.deleteAccountBatch(accountIds);
        System.out.println("delete " + rows +  " rows");
    }

    @Test
    public void updateAccount() {
        Account account3 = Account
                .builder()
                .id(8)
                .name("acc7")
                .type("工商银行")
                .money(700.00)
                .remark("交通补贴")
                .userId(3)
                .build();

        int rows = accountDao.updateAccount(account3);
        System.out.println("update " + rows +  " rows");

    }
}
