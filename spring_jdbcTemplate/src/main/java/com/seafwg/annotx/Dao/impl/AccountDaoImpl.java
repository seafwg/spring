package com.seafwg.annotx.Dao.impl;

import com.seafwg.annotx.Dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void outAccount(String outMan, int money) {
        String sql = "UPDATE account SET money = money-? WHERE username=?";
        jdbcTemplate.update(sql,money,outMan);
    }

    public void inAccount(String inMan, int money) {
        String sql = "UPDATE account SET money=money+? WHERE username=?";
        jdbcTemplate.update(sql,money,inMan);
    }
}
