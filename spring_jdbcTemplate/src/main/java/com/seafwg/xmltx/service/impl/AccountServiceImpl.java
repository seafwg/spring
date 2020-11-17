package com.seafwg.xmltx.service.impl;

import com.seafwg.xmltx.dao.AccountDao;
import com.seafwg.xmltx.service.AccountService;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
    public void transfer(String outMan, String inMan, int money) {
        accountDao.outAccount(outMan, money);
        int i = 3/0;
        accountDao.inAccount(inMan, money);
    }
}
