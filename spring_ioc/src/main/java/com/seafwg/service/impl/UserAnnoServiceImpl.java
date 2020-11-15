package com.seafwg.service.impl;

import com.seafwg.dao.UserAnnoDao;
import com.seafwg.service.UserAnnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 以Dao层注解为例：
 * ①@Repository("xxx")注入该类
 * ②在service中调用Dao,声明Dao,并给属性添加@Autowired+@Qualifier/@Resource注解，可获取到Dao
 *
 */

@Service("userAnnoService")
public class UserAnnoServiceImpl implements UserAnnoService {
//    @Autowired
//    @Qualifier("userAnnoDao")
    @Resource(name="userAnnoDao")
    private UserAnnoDao userAnnoDao;
//    public void setUserAnnoDao(UserAnnoDao userAnnoDao){
//        this.userAnnoDao = userAnnoDao;
//    }
    @Override
    public void save() {
        System.out.println("Anno Service Running...");
        userAnnoDao.save();
    }
}
