package com.crazyang.service;

import com.crazyang.common.baseClass.Page;
import com.crazyang.entity.OrderInfo;
import com.crazyang.model.OrderList;

import java.util.List;

/**
 * @ClassName OrderInfoService
 * @Description: 订单信息服务层接口
 * @Author zhouyang
 * @Date 2019/3/20 上午11:16.
 */

public interface OrderInfoService extends IService<OrderInfo> {

    List<OrderInfo> queryOrderList(Page<OrderInfo> page);

    OrderInfo getOne(int orderId);

    List<OrderInfo> findByUserId(int userId);

    OrderList findByOrderId(int orderId);

    int createOrder(OrderList orderList);

    int update(OrderInfo orderInfo);

    int deleteById(int orderId);
}
