package com.crazyang.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName Goods
 * @Description: 商品信息实体类
 * @Author zhouyang
 * @Date 2019/3/8 下午3:55.
 */
@Table(name = "goods")
@Entity
@Data
public class Goods implements Serializable {


    private static final long serialVersionUID = -2715441595609219097L;
    /**
     * 商品ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int goodsId;
    /**
     * 商品编号
     */
    private String goodsSn;
    /**
     *商品货号
     */
    private String productNo;
    /**
     *商品名称
     */
    private String goodsName;
    /**
     *商品图片
     */
    private String goodsImg;
    /**
     *市场价
     */
    private Double marketPrice;
    /**
     *门店价
     */
    private Double shopPrice;
    /**
     *预警库存
     */
    private int warnStock;
    /**
     *商品总库存
     */
    private int goodsStock;
    /**
     *是否上架
     */
    private int sale;
    /**
     *是否精品
     */
    private int best;
    /**
     *是否热销产品
     */
    private int hot;
    /**
     *删除标志
     */
    private int dataFlag;
    /**
     *创建时间
     */
    @Column(name="create_time")
    private Date createTime;

    @Override
    public String toString() {
        return "Goods{" +
                "goodsId=" + goodsId +
                ", goodsSn='" + goodsSn + '\'' +
                ", productNo='" + productNo + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsImg='" + goodsImg + '\'' +
                ", marketPrice=" + marketPrice +
                ", shopPrice=" + shopPrice +
                ", warnStock=" + warnStock +
                ", goodsStock=" + goodsStock +
                ", sale=" + sale +
                ", best=" + best +
                ", hot=" + hot +
                ", dataFlag=" + dataFlag +
                ", createTime=" + createTime +
                '}';
    }
}
