package com.seafwg.mapper;

import com.seafwg.domain.User;

import java.util.List;

/**
 * 代理方式实现Dao层接口的编写[无需编写Dao层的实现]：
 * 1) Mapper.xml文件中的namespace与mapper接口的[全限定名]相同
 * 2) Mapper接口方法名和Mapper.xml中定义的每个statement的id相同
 * 3) Mapper接口方法的输入参数类型和mapper.xml中定义的每个sql的parameterType的类型相同
 * 4) Mapper接口方法的输出参数类型和mapper.xml中定义的每个sql的resultType的类型相同
 */

public interface UserMapper {
    /**
     * 查询所有用户：
     *
     * @return
     */
    public List<User> findAllUser();

    /**
     * 查询操作：根据id查询用户：
     *
     * @param id
     * @return
     */
    public List<User> findUserById(int id);

    /**
     * 插入操作：插入一条数据：
     *
     * @param user
     */
    public void add(User user);
}
