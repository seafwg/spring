package com.seafwg.domain;

import java.util.Date;

public class Order {
    private int id;
    private Date ordertime;
    private double total;
    /**
     * 用户表和订单表的关系为，一个用户有多个订单，一个订单只从属于一个用户
     * 一对一查询的需求：查询一个订单，与此同时查询出该订单所属的用户
     */
    //当前订单属于哪一个用户：[封装用户与订单的关系]
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", ordertime=" + ordertime +
                ", total=" + total +
                ", user=" + user +
                '}';
    }
}
