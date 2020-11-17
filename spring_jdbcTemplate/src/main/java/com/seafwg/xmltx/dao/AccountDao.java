package com.seafwg.xmltx.dao;

public interface AccountDao {
    public void outAccount(String outMan, int money);
    public void inAccount(String inMan, int money);
}
