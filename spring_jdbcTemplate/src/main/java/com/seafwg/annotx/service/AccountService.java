package com.seafwg.annotx.service;

public interface AccountService {
    /**
     * 转账接口：
     * @param outMan
     * @param inMan
     * @param money
     */
    public void transfer(String outMan, String inMan, int money);
}
