package com.seafwg.domain;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.beans.PropertyVetoException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class domainJdbcTest {
    //注入jdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Test
    public void testJdbc() throws PropertyVetoException {
        //①创建数据源对象
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/seafwg");
        dataSource.setUser("root");
        dataSource.setPassword("root");
        //②创建jdbcTemplate
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        //执行sql操作
        String sql = "select * from account";
        List<Account> queryRes = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Account>(Account.class));
        System.out.println(queryRes);
    }

    /**
     * jdbcTemplate注解的方式测试
     */
    @Test
    public void testJdbcAnno() {
        String sql = "SELECT * FROM account";
        List<Account> queryRes = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Account>(Account.class));
        System.out.println(queryRes);
    }
    /**
     * JdbcTemplate基本操作-更新操作--update
     */
    @Test
    public void testUpdate() {
        String sql = "UPDATE account SET money=? WHERE username=?";
        int update = jdbcTemplate.update(sql, 200000, "wangqi");
        System.out.println(update);
    }
    @Test
    public void testDelete() {
        String sql = "DELETE FROM account WHERE username=?";
        int update = jdbcTemplate.update(sql, "shitou");
        System.out.println(update);
    }
    /**
     * JdbcTemplate基本操作-查询操作--query/queryForObject
     */
    //查询一个queryForObject(sql,new Beanxxx, "xxx");
    @Test
    public void queryOneTest() {
        String sql = "SELECT * FROM account WHERE username=?";
        Account query = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Account>(Account.class), "seafwg");
        System.out.println(query);
    }
    //查询所有query(sql,new Beanxxx)
    @Test
    public void queryAllTest() {
        String sql = "SELECT * FROM account";
        List<Account> queryAll = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Account>(Account.class));
        System.out.println(queryAll);
    }
    //聚合查询queryForObject(sql,Long.class)
    @Test
    public void queryCountTest() {
        String sql = "SELECT COUNT(*) FROM account";
        Long queryCount = jdbcTemplate.queryForObject(sql, Long.class);
        System.out.println(queryCount);
    }
}
