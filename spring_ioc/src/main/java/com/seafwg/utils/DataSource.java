package com.seafwg.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * 创建dataSource:druid,c3p0:
 * 1.开发步骤
 * ①导入数据源的坐标和数据库驱动坐标
 * ②创建数据源对象
 * ③设置数据源的基本连接数据
 * ④使用数据源获取连接资源和归还连接资源
 * 2.spring配置数据源：
 */
public class DataSource {

    //============①原始加载：============//
    /**
     * druid数据源对象：
     */
    @Test
    public void testDruid() throws SQLException {
        //①创建数据源
        DruidDataSource dataSource = new DruidDataSource();
        //②设置连接数据库
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/seafwg");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        //③获得连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

    /**
     * c3p0
     * @throws Exception
     */
    @Test
    public void testC3p0() throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/seafwg");
        dataSource.setUser("root");
        dataSource.setPassword("root");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
    //============①原始加载：============//

    //============②配置文件加载数据源：============//

    /**
     * 配置文件的druid
     */
    @Test
    public void testDruidConfig() throws SQLException {
        //①加载类路径下的jdbc.properties
        ResourceBundle rb = ResourceBundle.getBundle("jdbc");
        //②创建数据源对象
        DruidDataSource dataSource = new DruidDataSource();
        //③设置连接数据库
        dataSource.setDriverClassName(rb.getString("jdbc.driver"));
        dataSource.setUrl(rb.getString("jdbc.url"));
        dataSource.setUsername(rb.getString("jdbc.username"));
        dataSource.setPassword(rb.getString("jdbc.password"));
        //④获得链接
        DruidPooledConnection connection = dataSource.getConnection();
        System.out.println(connection);
    }
    @Test
    public void testC3p0Config() throws Exception {
        ResourceBundle rb = ResourceBundle.getBundle("jdbc");
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(rb.getString("jdbc.driver"));
        dataSource.setJdbcUrl(rb.getString("jdbc.url"));
        dataSource.setUser(rb.getString("jdbc.username"));
        dataSource.setPassword(rb.getString("jdbc.password"));
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
    //============②配置文件加载数据源：============//

    //============③spring配置数据源：============//
    @Test
    public void testC3p0Spring() throws SQLException {
        ApplicationContext application = new ClassPathXmlApplicationContext("applicationContext.xml");
        javax.sql.DataSource dataSource = (javax.sql.DataSource) application.getBean("dataSource");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
    @Test
    public void testDruidSpring() throws SQLException {
        ApplicationContext application = new ClassPathXmlApplicationContext("applicationContext.xml");
        javax.sql.DataSource druidDataSource = (javax.sql.DataSource) application.getBean("druidDataSource");
        Connection connection = druidDataSource.getConnection();
        System.out.println(connection);
    }
    //============③spring配置数据源：============//

    //============④spring配置数据源：============//
    @Test
    public void testC3p0Spring1() throws SQLException {
        ApplicationContext application = new ClassPathXmlApplicationContext("applicationContext.xml");
        javax.sql.DataSource dataSource = (javax.sql.DataSource) application.getBean("dataSourceImport");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
    //============④spring配置数据源：============//

}
