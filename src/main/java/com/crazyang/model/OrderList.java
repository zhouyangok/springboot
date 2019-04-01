package com.crazyang.model;

import com.crazyang.entity.OrderDetail;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @ClassName OrderList
 * @Description: 订单展示列表
 * @Author zhouyang
 * @Date 2019/3/20 下午1:51.
 */

@Data
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
    private Integer status;

    /**
     * 订单商品详情
     */
    private List<OrderDetail> orderDetails;


}
