package com.seafwg.annotx.Dao;

public interface AccountDao {
    /**
     * 转出余额信息：
     * @param outMan
     * @param money
     */
    public void outAccount(String outMan, int money);

    /**
     * 转入余额信息：
     * @param inMan
     * @param money
     */
    public void inAccount(String inMan, int money);
}
