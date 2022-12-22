package tech.snnukf.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import tech.snnukf.dao.IAccountDao;
import tech.snnukf.entity.Account;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * 账户模块接口实现
 *
 * @className: AccountDaoImpl
 * @author: simple.jbx
 * @date: 2022/12/20
 **/
@Repository
public class AccountDaoImpl implements IAccountDao {

    /**
     * 注入jdbc模板类
     */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    final static String ADD_SQL = "insert into t_account (name, type, money, remark, create_time, "
            + "update_time, user_id) values (?,?,?,?,now(),now(),?)";

    /**
     * description: 添加账户
     * 添加账户记录，返回受影响的行数
     *
     * @param account
     * @param: account
     * @return: int
     * @author: simple.jbx
     * @date: 2022/12/20 23:01
     */
    @Override
    public int addAccount(Account account) {
        Object[] objs = {account.getName(), account.getType(), account.getMoney(),
                account.getRemark(), account.getUserId()
            };
        int row = jdbcTemplate.update(ADD_SQL, objs);
        return row;
    }

    /**
     * description: 添加账户
     * 添加账户记录，返回主键
     *
     * @param account
     * @param: account
     * @return: int
     * @author: simple.jbx
     * @date: 2022/12/20 23:02
     */
    @Override
    public int addAccountHasKey(final Account account) {
        //定义keyHolder对象，获取记录主键值
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            //预先编译sql语句，并设置返回主键
            PreparedStatement ps = connection.prepareStatement(ADD_SQL, Statement.RETURN_GENERATED_KEYS);
            //设置参数
            ps.setString(1, account.getName());
            ps.setString(2 ,account.getType());
            ps.setDouble(3, account.getMoney());
            ps.setString(4, account.getRemark());
            ps.setInt(5, account.getUserId());
            return ps;
        }, keyHolder);
        //得到返回的主键
        Integer key = keyHolder.getKey().intValue();
        return key;
    }

    /**
     * description: 批量添加账户记录返回受影响的行数
     *
     * @param accountList
     * @param: accountList
     * @return: int
     * @author: simple.jbx
     * @date: 2022/12/20 23:04
     */
    @Override
    public int addAccountBatch(List<Account> accounts) {
        int rows = jdbcTemplate.batchUpdate(ADD_SQL, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                //设置参数
                preparedStatement.setString(1, accounts.get(i).getName());
                preparedStatement.setString(2 ,accounts.get(i).getType());
                preparedStatement.setDouble(3, accounts.get(i).getMoney());
                preparedStatement.setString(4, accounts.get(i).getRemark());
                preparedStatement.setInt(5, accounts.get(i).getUserId());
            }

            @Override
            public int getBatchSize() {
                return accounts.size();
            }
        }).length;
        return rows;
    }

    /**
     * description: 查询账户
     * 查询指定用户的账户的总记录数，返回总记录数
     *
     * @param userId
     * @param: userId
     * @return: int
     * @author: simple.jbx
     * @date: 2022/12/20 23:05
     */
    @Override
    public int queryAccountCount(int userId) {
        String sql = "select count(*) from t_account where user_id = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, userId);
        return count;
    }

    /**
     * description: 查询账户
     * 查询指定账户的详细信息
     *
     * @param accountId
     * @param: accountId
     * @return: tech.snnukf.entity.Account
     * @author: simple.jbx
     * @date: 2022/12/20 23:06
     */
    @Override
    public Account queryAccountById(int accountId) {
        String sql = "select * from t_account where id = ?";
        Account account = jdbcTemplate.queryForObject(sql, new Object[]{accountId},
                (resultSet, i) -> {
                    Account acc = new Account();
                    acc.setId(resultSet.getInt("id"));
                    acc.setMoney(resultSet.getDouble("money"));
                    acc.setName(resultSet.getString("name"));
                    acc.setRemark(resultSet.getString("remark"));
                    acc.setType(resultSet.getString("type"));
                    acc.setCreateTime(resultSet.getDate("create_time"));
                    acc.setUpdateTime(resultSet.getDate("update_time"));
                    return acc;
                });
        return account;
    }

    /**
     * description: 查询账户
     * 多条件查询指定用户的账户列表，返回账户集合
     *
     * @param userId
     * @param accountName
     * @param accountType
     * @param createTime
     * @param: userId
     * @param: accountName
     * @param: accountType
     * @param: createTime
     * @return: java.util.List<tech.snnukf.entity.Account>
     * @author: simple.jbx
     * @date: 2022/12/20 23:08
     */
    @Override
    public List<Account> queryAccountByParams(Integer userId, String accountName, String accountType, String createTime) {
        return null;
    }

    /**
     * description: 修改账户
     * 修改用户记录，返回受到影响的行数
     *
     * @param account
     * @param: account
     * @return: int
     * @author: simple.jbx
     * @date: 2022/12/20 23:09
     */
    @Override
    public int updateAccount(Account account) {
        return 0;
    }

    /**
     * description: 修改账户
     * 批量修改用户记录，返回受影响的行数
     *
     * @param accountList
     * @param: accountList
     * @return: int
     * @author: simple.jbx
     * @date: 2022/12/20 23:10
     */
    @Override
    public int updateAccountBatch(List<Account> accountList) {
        return 0;
    }

    /**
     * description: 删除账户
     * 删除账户记录，返回受影响的行数
     *
     * @param accountId
     * @param: accountId
     * @return: int
     * @author: simple.jbx
     * @date: 2022/12/20 23:11
     */
    @Override
    public int deleteAccount(int accountId) {
        return 0;
    }

    /**
     * description: 删除账户
     * 批量删除账户，返回受到影响的行数
     *
     * @param accountIds
     * @param: accountIds
     * @return: int
     * @author: simple.jbx
     * @date: 2022/12/20 23:12
     */
    @Override
    public int deleteAccountBatch(List<Integer> accountIds) {
        return 0;
    }
}
