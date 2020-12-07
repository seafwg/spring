package com.seafwg.anno_mapper;

import com.seafwg.domain.Order;
import com.seafwg.domain.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AnOrderMapper {
    /**
     * 一对一查询的需求：查询一个订单，与此同时查询出该订单所属的用户
     *
     * @return property:实体类的属性：
     * column:数据库字段
     * <p>
     * javaType: 当前实体类下所描述的对象的class
     * @one:表示一对一的查询: property:实体类属性
     * column:根据第一次查询的结果作为再次查询的条件
     * select="xxx",实体类下描述对象的查询方法
     * 整体理解：
     * ①查询主表
     * ②根据主表的外键[人活着任一条件]查询其他表
     */
    @Select("select * from orders")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "ordertime", column = "ordertime"),
            @Result(property = "total", column = "total"),
            @Result(
                    property = "user",
                    column = "uid",
                    javaType = User.class,
                    one = @One(select = "com.seafwg.anno_mapper.AnUserMapper.findById")
            )
    })
    public List<Order> findAll();

    @Select("select * from orders where uid=#{uid}")
    public List<Order> findOrderByUid(int uid);
}
