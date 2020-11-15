package com.seafwg.dao.impl;

import com.seafwg.dao.UserAnnoDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component("userAnnoDao")
@Repository("userAnnoDao")
public class UserAnnoDaoImpl implements UserAnnoDao {
    @Override
    public void save() {
        System.out.println("Running...");
    }
}
