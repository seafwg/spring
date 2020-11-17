package com.seafwg.xmltx.dao.impl;

import com.seafwg.xmltx.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class AccountDaoImpl implements AccountDao {
    //①数据源的加载：
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
    //②配置加载 <property name="jdbcTemplate" ref="jdbcTemplate"></property>
    private JdbcTemplate jdbctemplate;
    public void setJdbcTemplate(JdbcTemplate jdbctemplate) {
        this.jdbctemplate = jdbctemplate;
    }
    public void outAccount(String outMan, int money) {
        String sql = "UPDATE account SET money=money-? WHERE username=?";
        jdbctemplate.update(sql,money,outMan);
    }

    public void inAccount(String inMan, int money) {
        String sql = "UPDATE account SET money=money+? WHERE username=?";
        jdbctemplate.update(sql,money,inMan);
    }
}
