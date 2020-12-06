package com.seafwg.mapper;

import com.seafwg.domain.User;

import java.util.List;

public interface UserMapper {
    /**
     * 一对多查询的需求：查询一个用户，与此同时查询出该用户具有的订单
     * 用户表和订单表的关系为，一个用户有多个订单，一个订单只从属于一个用户
     *
     * @return
     */
    public List<User> findAll();

    /**
     * 多对多查询的需求：查询用户同时查询出该用户的所有角色
     * 用户表和角色表的关系为，一个用户有多个角色，一个角色被多个用户使用
     *
     * @return
     */
    public List<User> findUserAndRoleAll();
}
