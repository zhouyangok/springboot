package com.crazyang.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName OrderInfo
 * @Description: 订单表
 * @Author zhouyang
 * @Date 2019/3/20 上午10:33.
 */

@Table(name = "order_info")
@Entity
public class OrderInfo implements Serializable {

    private static final long serialVersionUID = 9052939513013700838L;

    /**
     *订单id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private BigDecimal orderPrice;

    /**
     *订单状态
     */
    private int status;

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

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "orderId=" + orderId +
                ", orderNo='" + orderNo + '\'' +
                ", userId=" + userId +
                ", createTime=" + createTime +
                ", orderPrice=" + orderPrice +
                ", status=" + status +
                '}';
    }
}
