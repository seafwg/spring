package com.seafwg.domain.demo;

import com.seafwg.domain.dao.UserDao;
import com.seafwg.domain.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** spring快速入门：
 * ①导入 Spring 开发的基本包坐标
 * ②编写 Dao 接口和实现类
 * ③创建 Spring 核心配置文件
 * ④在 Spring 配置文件中配置 UserDaoImpl
 * ⑤使用 Spring 的 API 获得 Bean 实例
 */
public class UserDaoDemo {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) app.getBean("UserDao");
        userDao.save();
    }

    // UserDaoImpl test:
    @Test
    public void test() {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) app.getBean("UserDao");
        userDao.save();
    }

    // UserServiceImpl test:
    @Test
    public void test1() {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) app.getBean("UserService");
        userService.save();
    }
}
