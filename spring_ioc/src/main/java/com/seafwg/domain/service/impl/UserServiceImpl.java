package com.seafwg.domain.service.impl;

import com.seafwg.domain.dao.UserDao;
import com.seafwg.domain.service.UserService;

public class UserServiceImpl implements UserService {
    /**
     * Bean依赖注入的set方法：
     * ①声明是有属性
     * ②创建对应的set方法
     * ③配置Spring容器调用set方法进行注入 [在service的标签里面配置property标签属性]
     *   <property name="userDao" ref="userDao"/>
     *   name:setUserDao => userDao:
     *   ref:userDao => 指向bean的id
     */
    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    // 正常调用Dao层：
//    @Override
//    public void save() {
//        System.out.println("service running...");
//        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
//        UserDao userDao = (UserDao) app.getBean("UserDao");
//        userDao.save();
//    }

    /**
     * Bean的依赖注入：set方法：
     */
    @Override
    public void save() {
        userDao.save();
    }
}
