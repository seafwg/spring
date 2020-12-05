package com.seafwg.test;

import com.seafwg.domain.User;
import com.seafwg.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserMapperTest {
    private UserMapper mapper;

    /**
     * 初始化sqlSession
     *
     * @throws IOException
     */
    @Before
    public void testBefore() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        mapper = sqlSession.getMapper(UserMapper.class);
    }

    /**
     * 查询所有的用户：
     */
    @Test
    public void test() {
        List<User> userList = mapper.findAllUser();
        System.out.println(userList);
    }

    /**
     * 查询指定的用户：
     */
    @Test
    public void test2() {
        List<User> userById = mapper.findUserById(3);
        System.out.println(userById);
    }

    @Test
    public void test3() {
        User user = new User();
        user.setId(6);
        user.setUsername("assassin");
        user.setPassword("123321");
        System.out.println(user);
        mapper.add(user);
    }
}
