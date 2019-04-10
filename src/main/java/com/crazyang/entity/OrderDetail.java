package com.crazyang.entity;

import lombok.Data;

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
@Data
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
