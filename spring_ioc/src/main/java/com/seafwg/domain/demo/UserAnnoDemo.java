package com.seafwg.domain.demo;

import com.seafwg.domain.annoConfig.SpringConfigurationCore;
import com.seafwg.domain.dao.UserAnnoDao;
import com.seafwg.domain.service.UserAnnoService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class UserAnnoDemo {
    @Test
    public void annoServiceTest() {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserAnnoService userAnnoService = (UserAnnoService) app.getBean("userAnnoService");
        userAnnoService.save();
    }
    @Test
    public void annoDaoTest() {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserAnnoDao userAnnoDao = (UserAnnoDao) app.getBean("userAnnoDao");
        userAnnoDao.save();
    }

    /**
     * 新注解spring核心配置类测试：
     */
    @Test
    public void springConfigurationCoreTest() throws SQLException {
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfigurationCore.class);
        DataSource dataSource = (DataSource) app.getBean("dataSource");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}
