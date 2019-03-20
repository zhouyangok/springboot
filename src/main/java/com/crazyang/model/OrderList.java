package com.crazyang.model;

import com.crazyang.entity.OrderDetail;

import java.util.Date;
import java.util.List;

/**
 * @ClassName OrderList
 * @Description: 订单展示列表
 * @Author zhouyang
 * @Date 2019/3/20 下午1:51.
 */

public class OrderList {

    private Integer orderId;
    /**
     *订单号
     */
    private String orderNo;
    /**
     *用户id
     */
    private Integer userId;

    /**
     *订单创建时间
     */
    private Date createTime;

    /**
     *订单总价
     */
    private Double orderPrice;

    /**
     *订单状态
     */
    private int status;

    /**
     * 订单商品详情
     */
    private List<OrderDetail> orderDetails;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }


}
