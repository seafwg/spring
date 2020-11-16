package com.seafwg.domain.dao.impl;

import com.seafwg.domain.dao.UserAnnoDao;
import org.springframework.stereotype.Repository;

//@Component("userAnnoDao")
@Repository("userAnnoDao")
public class UserAnnoDaoImpl implements UserAnnoDao {
    @Override
    public void save() {
        System.out.println("Running...");
    }
}
