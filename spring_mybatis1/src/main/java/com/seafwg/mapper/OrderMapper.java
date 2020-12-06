package com.seafwg.mapper;

import com.seafwg.domain.Order;

import java.util.List;

public interface OrderMapper {
    /**
     * 查询一个订单，与此同时查询出该订单所属的用户
     * 用户表和订单表的关系为：一个用户有多个订单，一个订单只从属于一个用户
     *
     * @return
     */
    List<Order> findAll();
}
