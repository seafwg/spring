package com.seafwg.demo;

import com.seafwg.dao.UserAnnoDao;
import com.seafwg.service.UserAnnoService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
}
