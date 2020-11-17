package com.seafwg.annotx.service.impl;

import com.seafwg.annotx.Dao.AccountDao;
import com.seafwg.annotx.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    @Transactional
    public void transfer(String outMan, String inMan, int money) {
        /**
         * 调用持久层转账转出方法：
         */
        accountDao.outAccount(outMan, money);

//        int i = 3/0;

        /**
         * 调用持久层转账转入方法
         */
        accountDao.inAccount(inMan, money);
    }
}
