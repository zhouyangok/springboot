package com.crazyang.service.impl;

import com.crazyang.common.exception.BusinessException;
import com.crazyang.common.baseClass.Page;
import com.crazyang.common.utils.ArithUtils;
import com.crazyang.dao.OrderInfoMapper;
import com.crazyang.entity.OrderDetail;
import com.crazyang.entity.OrderInfo;
import com.crazyang.model.OrderList;
import com.crazyang.service.OrderInfoService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName OrderInfoServiceImpl
 * @Description: 订单信息实现层
 * @Author zhouyang
 * @Date 2019/3/20 上午11:29.
 */
@Service
public class OrderInfoServiceImpl extends BaseService<OrderInfo> implements OrderInfoService {

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Override
    public List<OrderInfo> queryOrderList(Page<OrderInfo> page) {
        PageHelper.startPage(page.getPage(), page.getRows());
        return orderInfoMapper.queryOrderList(page.getCondition());
    }

    @Override
    public OrderInfo getOne(int orderId) {
        return orderInfoMapper.getOne(orderId);
    }

    @Override
    public List<OrderInfo> findByUserId(int userId) {
        return orderInfoMapper.findByUserId(userId);
    }

    @Override
    public OrderList findByOrderId(int orderId) {
        OrderInfo orderInfo = orderInfoMapper.getOne(orderId);
        List<OrderDetail> orderDetails = orderInfoMapper.queryOrderDetailByOrderId(orderId);
        OrderList orderList = new OrderList();
        BeanUtils.copyProperties(orderInfo, orderList);
        orderList.setOrderDetails(orderDetails);
        return orderList;
    }

    @Override
    /**
     * 创建订单
     */
    public int createOrder(OrderList orderList) {

        //TODO 如何创建不重复的id
        OrderInfo orderInfo = new OrderInfo();
        Double price = 0D;
        int orderId = 10001;

        //存入订单信息
        //存入订单详情
        orderInfo.setOrderId(orderId);
        //设置订单编号
        orderInfo.setOrderNo(String.valueOf(System.currentTimeMillis()));
        //订单状态：状态：1、未付款，2、已付款，3、未发货，4、已发货
        orderInfo.setStatus(1);
        orderInfo.setUserId(orderList.getUserId());
        orderInfo.setCreateTime(new Date());
        for (OrderDetail orderDetail : orderList.getOrderDetails()) {
            OrderDetail orderDetailData = new OrderDetail();

            orderDetailData.setCreateTime(new Date());
            orderDetailData.setOrderId(orderId);
            orderDetailData.setGoodsNum(orderDetail.getGoodsNum());
            orderDetailData.setGoodsId(orderDetail.getGoodsId());
            orderDetailData.setGoodsPrice(orderDetail.getGoodsPrice());
            orderDetailData.setGoodsName("goodsName" + orderDetail.getGoodsId());
            orderInfoMapper.insertOrderDetail(orderDetailData);
            System.out.println(orderDetail.getGoodsNum());
            System.out.println(orderDetail.getGoodsPrice());
            price += ArithUtils.mul(orderDetail.getGoodsPrice(), orderDetail.getGoodsNum());
        }
        orderInfo.setOrderPrice(price);
        return orderInfoMapper.insert(orderInfo);
    }

    @Override
    public int update(OrderInfo orderInfo) {
        return orderInfoMapper.update(orderInfo);
    }

    @Override
    public int deleteById(int orderId) {
        int result = orderInfoMapper.deleteByOrderId(orderId);
        if (result < 1) {
            throw new BusinessException("删除订单错误");
        }
        return orderInfoMapper.deleteById(orderId);
    }
}
