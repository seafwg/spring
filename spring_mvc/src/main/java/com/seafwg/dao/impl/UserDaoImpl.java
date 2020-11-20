package com.seafwg.dao.impl;

import com.seafwg.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    public void save() {
        System.out.println("UserDaoImpl Running...");
    }
}
