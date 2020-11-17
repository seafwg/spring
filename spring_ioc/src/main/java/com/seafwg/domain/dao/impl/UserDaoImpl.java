package com.seafwg.domain.dao.impl;

import com.seafwg.domain.dao.UserDao;
import com.seafwg.domain.User;

import java.util.List;

/**
 * Bean的依赖注入的数据类型：
 * ①普通数据类型注入：
 * ②引用类型注入：
 * ③集合数据类型注入：
 *
 * 基本步骤：
 * ①设置属性
 * ②设置对应的set方法
 * ③在核心配置文件配置property标签
 */

public class UserDaoImpl implements UserDao {
    //①普通数据类型注入：
    private String company;
    private int age;
    //②集合类型注入：
    private List<String> stringList;
    //③集合类型：List<User>注入
    private List<User> userList;

    public void setCompany(String company) {
        this.company = company;
    }

    public void setAge(int age) {
        this.age = age;
    }
    //集合注入的set方法：
    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }
    //集合类型：List<User>注入的set方法：
    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public void save() {
        System.out.println("Running...");
        //普通数据注入的测试输出：①
        System.out.println(company+"==="+age);
        //集合类型注入的测试输出：②
        System.out.println(stringList);
        //集合类型List<User>注入的测试输出：③
        System.out.println(userList);
    }
}
