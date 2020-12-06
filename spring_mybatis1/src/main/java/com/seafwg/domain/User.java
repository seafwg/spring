package com.seafwg.domain;

import javax.management.relation.Role;
import java.util.List;

public class User {
    private int id;
    private String username;
    private String password;

    /**
     * 用户表和订单表的关系为，一个用户有多个订单，一个订单只从属于一个用户
     * 一对多查询的需求：查询一个用户，与此同时查询出该用户具有的订单
     */
    // 添加当前用户有哪些订单：
    private List<Order> orderList;
    /**
     * 用户表和角色表的关系为，一个用户有多个角色，一个角色被多个用户使用
     * 多对多查询的需求：查询用户同时查询出该用户的所有角色
     */
    // 添加当前用户有哪些角色：
    private List<Role> roleList;

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", orderList=" + orderList +
                ", roleList=" + roleList +
                '}';
    }
}
