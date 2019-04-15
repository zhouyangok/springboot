package com.crazyang.service.impl;

import com.crazyang.common.enums.OrderStatusEnum;
import com.crazyang.common.enums.ResultEnum;
import com.crazyang.common.exception.BusinessException;
import com.crazyang.common.baseClass.Page;
import com.crazyang.common.utils.ArithUtils;
import com.crazyang.common.utils.GetTimeID;
import com.crazyang.dao.master.OrderInfoMapper;
import com.crazyang.entity.Goods;
import com.crazyang.entity.OrderDetail;
import com.crazyang.entity.OrderInfo;
import com.crazyang.model.OrderList;
import com.crazyang.service.GoodsService;
import com.crazyang.service.OrderInfoService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
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
    @Autowired
    private GoodsService goodsService;

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


    /**
     * 创建订单
     * 加入事务
     */
    @Override
    @Transactional
    public int createOrder(OrderList orderList) {

        //TODO 如何创建不重复的id
        OrderInfo orderInfo = new OrderInfo();
        BigDecimal price = new BigDecimal(BigInteger.ZERO);
        //1.设置订单id
        orderInfo.setOrderId(GetTimeID.getTimeId());
        //2.设置订单编号
        orderInfo.setOrderNo(GetTimeID.getGuid());
        //3.订单状态：状态：1、未付款，2、已付款，3、未发货，4、已发货
        orderInfo.setStatus(OrderStatusEnum.NEW.getCode());
        orderInfo.setUserId(orderList.getUserId());
        orderInfo.setCreateTime(new Date());
        for (OrderDetail orderDetail : orderList.getOrderDetails()) {
            //获取商品信息
            Goods productInfo = goodsService.findById(orderDetail.getGoodsId());
            //商品不存在则抛出异常
            if (productInfo == null) {
                throw new BusinessException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            OrderDetail orderDetailData = new OrderDetail();
            orderDetailData.setCreateTime(new Date());
            orderDetailData.setOrderId(orderInfo.getOrderId());
            orderDetailData.setGoodsNum(orderDetail.getGoodsNum());
            orderDetailData.setGoodsId(orderDetail.getGoodsId());
            orderDetailData.setGoodsPrice(orderDetail.getGoodsPrice());
            orderDetailData.setGoodsName("goodsName" + orderDetail.getGoodsId());
            //4.将详情存入数据库
            orderInfoMapper.insertOrderDetail(orderDetailData);
            //5.计算订单总价
            price = ArithUtils.mul(orderDetail.getGoodsPrice(), orderDetail.getGoodsNum()).add(price);
        }
        orderInfo.setOrderPrice(price);
        //6.将订单主表写入数据库
        int result = orderInfoMapper.insert(orderInfo);
        //7.减库存

        return result;
    }


    /**
     * 取消订单
     *
     * @param orderList
     * @return
     */
    @Override
    @Transactional
    public int cancelOrder(OrderList orderList) {
        OrderInfo orderInfo = new OrderInfo();
        //判断订单状态，如果订单状态不是新订单，则抛出异常
        if (!orderList.getStatus().equals(OrderStatusEnum.NEW.getCode())) {
            throw new BusinessException(ResultEnum.ORDER_STATUS_ERROR);
        }
        //修改订单状态,并保存到数据库
        orderList.setStatus(OrderStatusEnum.CANCEL.getCode());
        BeanUtils.copyProperties(orderList, orderInfo);
        int result = orderInfoMapper.update(orderInfo);
        if (result < 1) {
            throw new BusinessException(ResultEnum.ORDER_UPDATE_FAIL);
        }
        //将商品返还库存
        if (CollectionUtils.isEmpty(orderList.getOrderDetails())) {
            throw new BusinessException(ResultEnum.ORDER_DETAIL_EMPTY);
        }
        //如果用户已经付款，则将钱款返还给用户

        return 1;
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
