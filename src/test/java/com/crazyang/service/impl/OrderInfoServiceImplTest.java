package com.crazyang.service.impl;

import com.crazyang.common.utils.GetTimeID;
import com.crazyang.entity.OrderDetail;
import com.crazyang.model.OrderList;
import com.crazyang.service.OrderInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @ClassName OrderInfoServiceImplTest
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/3/20 下午5:56.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderInfoServiceImplTest {

    @Autowired
    private OrderInfoService service;

    @Test
    public void queryOrderList() throws Exception {
    }

    @Test
    public void getOne() throws Exception {
    }

    @Test
    public void findByUserId() throws Exception {
    }

    @Test
    public void findByOrderId() throws Exception {
    }

    @Test
    public void createOrder() throws Exception {

        OrderList orderList = new OrderList();
        orderList.setUserId(1);
        List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
        for (int i = 1; i < 3; i++) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setGoodsId(i);
            orderDetail.setGoodsNum(i);
            orderDetail.setGoodsPrice(7.3126);
            orderDetailList.add(orderDetail);
        }
        orderList.setOrderDetails(orderDetailList);
        int i = service.createOrder(orderList);
        System.out.println(i);
    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void deleteById() throws Exception {
    }

}