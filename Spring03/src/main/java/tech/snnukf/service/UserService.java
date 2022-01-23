package tech.snnukf.service;

import tech.snnukf.dao.UserDao;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author simple.jbx
 * @ClassName UserService
 * @description //TODO
 * @email jb.xue@qq.com
 * @github https://github.com/simple-jbx
 * @date 2022/01/07/ 18:48
 */
public class UserService {

    //手动实例化
    //private UserDao userDao = new UserDao();

    //业务逻辑对象 JavaBean对象 set方法注入
    ///*
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    // */

    //常用类型 基本类型
    private String host;
    public void setHost(String host) {
        this.host = host;
    }

    //集合注入
    private List<String> list;
    public void setList(List<String> list) {
        this.list = list;
    }

    //Set 集合
    private Set<String> set;
    public void setSet(Set<String> set) {
        this.set = set;
    }

    //Map
    private Map<String, Object> map;

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    //properties属性对象
    private Properties properties;

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void printList() {
        list.forEach((v -> System.out.println(v)));
    }

    public void printSet() {
        set.forEach((v -> System.out.println(v)));
    }

    public void printMap() {
        map.forEach(((k, v) -> System.out.println(k + "=" + v)));
    }

    public void printProperties() {
        properties.forEach(((k, v) -> System.out.println(k + "=" + v)));
    }


    public void test() {
        userDao.test();
        System.out.println(host);
        printList();
        printMap();
        printSet();
        printProperties();
        System.out.println("UserService Test...");
    }
}
