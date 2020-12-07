package com.seafwg.mapper;

import com.seafwg.anno_mapper.AnOrderMapper;
import com.seafwg.anno_mapper.AnUserMapper;
import com.seafwg.domain.Order;
import com.seafwg.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import javax.management.relation.Role;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AnnoMybatisTest {
    private AnOrderMapper orderMapper;
    private AnUserMapper userMapper;

    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        orderMapper = sqlSession.getMapper(AnOrderMapper.class);
        userMapper = sqlSession.getMapper(AnUserMapper.class);
    }

    /**
     * 测试查询一对一表：一个订单所属一个用户：
     */
    @Test
    public void test() {
        List<Order> orderList = orderMapper.findAll();
        for (Order order : orderList) {
            System.out.println(order);
        }
    }

    /**
     * 测试查询一对多表：一个用户有多个订单信息
     */
    @Test
    public void test2() {
        List<User> allUserAndOrder = userMapper.findAllUserAndOrder();
        for (User user : allUserAndOrder) {
            System.out.println(user.getUsername());
            List<Order> orderList = user.getOrderList();
            for (Order order : orderList) {
                System.out.println(order);
            }
            System.out.println("==============================");
        }
    }

    /**
     * 测试查询多对多表：一个用户有多个角色，一个角色被多个用户占有：
     */
    @Test
    public void test3() {
        List<User> allUserAndRole = userMapper.findAllUserAndRole();
        for (User user : allUserAndRole) {
            System.out.println(user);
            System.out.println(user.getUsername());
            List<Role> roleList = user.getRoleList();
            for (Role role : roleList) {
                System.out.println(role);
            }
            System.out.println("=================================");
        }
    }
}
