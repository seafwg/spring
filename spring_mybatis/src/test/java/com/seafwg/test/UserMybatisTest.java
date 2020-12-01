package com.seafwg.test;

import com.seafwg.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserMybatisTest {
    /**
     * 查询所有的User集合：select * from table;
     * @throws IOException
     */
    @Test
    public void test1() throws IOException {
        //①加载mybatis核心配置文件：
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //②获得sqlSessionFactory工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //③获得sqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //④执行操作
        List<User> userList = sqlSession.selectList("userMapper.findAllUser");
        System.out.println(userList);
        //⑤释放资源：
        sqlSession.close();
    }

    /**
     * 根据id查询一条数据：select * from table where xxx=xxx;
     * @throws IOException
     */
    @Test
    public void test2() throws IOException {
        //①加载mybatis核心配置文件：
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //②获得sqlSessionFactory工厂对象：
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //③获得sqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //④执行操作：
        User user = sqlSession.selectOne("userMapper.findUserById", 2);
        System.out.println(user);
        //⑤释放资源
        sqlSession.close();
    }

    /**
     * 插入一条数据 insert into table values(xxx=xxx, ...);
     * @throws IOException
     */
    @Test
    public void test3() throws IOException {
        //模拟一条数据：
        User user = new User();
        user.setUsername("lisi");
        user.setPassword("222333");
        user.setId(4);
        //①加载mybatis核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //②获取sqlSessionFactory会话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //③获取sqlSession会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //④执行操作
        int insert = sqlSession.insert("userMapper.add", user);
        System.out.println(insert);
        //***** :只要是设计表的修改操作都要添加事务管理，mybatis需要提价事务 *****//
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 更新用户一条数据：update table xxx=xxx,xxx=xxx where xxx=xxx;
     * @throws IOException
     */
    @Test
    public void test4() throws IOException {
        User user = new User();
        user.setId(5);
        user.setUsername("zhaosi");
        user.setPassword("123321");
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int update = sqlSession.update("userMapper.modifyUser",user);
        System.out.println(update);
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 删除数据-根据id删除一条用户：delete from table where xxx=xxx;
     * @throws IOException
     */
    @Test
    public void test5() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int delete = sqlSession.delete("userMapper.delUser", 4);
        sqlSession.commit();
        sqlSession.close();
    }
}
