package com.seafwg.anno_mapper;

import com.seafwg.domain.Order;
import com.seafwg.domain.User;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AnUserMapper {
    /**
     * 根据id查询user
     *
     * @param id
     * @return
     */
    @Select("select * from user where id=#{id}")
    public User findById(int id);

    /**
     * 一对多查询的需求：查询一个用户，与此同时查询出该用户具有的订单
     *
     * @return
     */
    @Select("select * from user")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(
                    property = "orderList",
                    column = "id",
//                  为什么是List.class => 类型的class
                    javaType = List.class,
                    many = @Many(select = "com.seafwg.anno_mapper.AnOrderMapper.findOrderByUid")
            )
    })
    public List<User> findAllUserAndOrder();

    /**
     * 多对多查询的需求：查询用户同时查询出该用户的所有角色
     *
     * @return
     */
    @Select("select * from user")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(
                    property = "roleList",
                    column = "id",
                    javaType = List.class,
                    many = @Many(select = "com.seafwg.anno_mapper.AnRoleMapper.findRoleByUid")
            )
    })
    public List<User> findAllUserAndRole();


    /**
     * 注解多表查询总结：
     * 相同点：配置基本相同，步骤也基本相同：
     * 步骤：先查出一张表，根据这一张表的值作为再次查询的条件再次查询其他表：
     * 不同点：
     * 一对一查询和一对多总共查询两张表：查出一张表，再次查询其他表
     * 多对多查询：先查询出一张表，再查中间表和第三张表，第二次查询的是两张表
     */
}
