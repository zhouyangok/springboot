package com.crazyang.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName OrderDetail
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/3/20 下午1:44.
 */
@Table(name = "order_detail")
@Entity
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 2437067823498591670L;
    /**
     * 订单详情id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer detailId;
    /**
     * 订单id
     */
    private Integer orderId;

    /**
     * 商品id
     */
    private Integer goodsId;

    /**
     * 商品价格
     */
    private Double goodsPrice;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品数量
     */
    private Integer goodsNum;
    /**
     * 创建时间
     */
    private Date createTime;

    public Integer getDetailId() {
        return detailId;
    }

    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "detailId=" + detailId +
                ", orderId=" + orderId +
                ", goodsId=" + goodsId +
                ", goodsPrice=" + goodsPrice +
                ", goodsName='" + goodsName + '\'' +
                ", goodsNum=" + goodsNum +
                ", createTime=" + createTime +
                '}';
    }
}
