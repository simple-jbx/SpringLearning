package tech.snnukf.dao;

import tech.snnukf.entity.Account;

import java.util.List;

/**
 * 账户模块接口定义
 *  1.添加账户
 *      添加账户记录，返回受影响的行数、主键
 *      批量添加账户记录，返回受影响的行数
 *
 *  2.修改账户
 *      修改用户记录，返回受影响的行数
 *      批量修改账户记录，返回受影响的行数
 *
 *  3.删除账户
 *      删除用户记录，返回受影响的行数
 *      批量删除账户记录，返回受影响的行数
 *
 *  4.查询账户
 *      查询指定用户的账户的总记录数，返回总记录数
 *      查询指定账户的账户详情，返回账户对象
 *      多条件查询指定用户的账户列表，返回账户集合
 *
 * @className: IAccountDao
 * @author: simple.jbx
 * @date: 2022/12/20
 **/
public interface IAccountDao {
    
    /**
     * description: 添加账户
     *  添加账户记录，返回受影响的行数
     *
     * @param: account
     * @return: int
     * @author: simple.jbx
     * @date: 2022/12/20 23:01
     */
    int addAccount(Account account);

    /**
     * description: 添加账户
     *  添加账户记录，返回主键
     *
     * @param: account
     * @return: int
     * @author: simple.jbx
     * @date: 2022/12/20 23:02
     */
    int addAccountHasKey(Account account);

    /**
     * description: 批量添加账户记录返回受影响的行数
     *
     * @param: accountList
     * @return: int
     * @author: simple.jbx
     * @date: 2022/12/20 23:04
     */
    int addAccountBatch(List<Account> accountList);

    /**
     * description: 查询账户
     *  查询指定用户的账户的总记录数，返回总记录数
     *
     * @param: userId
     * @return: int
     * @author: simple.jbx
     * @date: 2022/12/20 23:05
     */
    int queryAccountCount(int userId);

    /**
     * description: 查询账户
     *  查询指定账户的详细信息
     *
     * @param: accountId
     * @return: tech.snnukf.entity.Account
     * @author: simple.jbx
     * @date: 2022/12/20 23:06
     */
    Account queryAccountById(int accountId);

    /**
     * description: 查询账户
     *  多条件查询指定用户的账户列表，返回账户集合
     *
     * @param: userId
     * @param: accountName
     * @param: accountType
     * @param: createTime
     * @return: java.util.List<tech.snnukf.entity.Account>
     * @author: simple.jbx
     * @date: 2022/12/20 23:08
     */
    List<Account> queryAccountByParams(Integer userId, String accountName, String accountType, String createTime);

    /**
     * description: 修改账户
     *  修改用户记录，返回受到影响的行数
     * @param: account
     * @return: int
     * @author: simple.jbx
     * @date: 2022/12/20 23:09
     */
    int updateAccount(Account account);

    /**
     * description: 修改账户
     *  批量修改用户记录，返回受影响的行数
     *
     * @param: accountList
     * @return: int
     * @author: simple.jbx
     * @date: 2022/12/20 23:10
     */
    int updateAccountBatch(List<Account> accountList);
    
    /**
     * description: 删除账户
     *  删除账户记录，返回受影响的行数
     *
     * @param: accountId
     * @return: int
     * @author: simple.jbx
     * @date: 2022/12/20 23:11
     */
    public int deleteAccount(int accountId);

    /**
     * description: 删除账户
     *  批量删除账户，返回受到影响的行数
     *
     * @param: accountIds
     * @return: int
     * @author: simple.jbx
     * @date: 2022/12/20 23:12
     */
    public int deleteAccountBatch(List<Integer> accountIds);

}
