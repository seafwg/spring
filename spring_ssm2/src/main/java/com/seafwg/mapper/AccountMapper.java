package com.seafwg.mapper;

import com.seafwg.domain.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountMapper {
    /**
     * 保存账户信息：
     *
     * @param account
     */
    void save(Account account);

    /**
     * 查询账户信息：
     *
     * @return
     */
    List<Account> findAll();
}
