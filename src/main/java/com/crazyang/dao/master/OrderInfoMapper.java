package com.crazyang.dao.master;

import com.crazyang.common.baseClass.MyMapper;
import com.crazyang.entity.OrderDetail;
import com.crazyang.entity.OrderInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @ClassName OrderInfo
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/3/20 上午11:12.
 */
@Component
public interface OrderInfoMapper extends MyMapper<OrderInfo> {

    List<OrderInfo> queryOrderList(Map<String, Object> map);

    @Select("SELECT * FROM order_info WHERE orderId=#{orderId}")
    OrderInfo getOne(int orderId);

    @Select("SELECT * FROM order_info WHERE userId=#{userId}")
    List<OrderInfo> findByUserId(int  userId);

    /**
     * 根据订单id查找订单详情
     * @param orderId
     * @return
     */
    List<OrderDetail> queryOrderDetailByOrderId(int orderId);

    /**
     *根据订单id删除订单详情信息
     * @param orderId
     * @return
     */
    @Delete("DELETE FROM order_detail WHERE orderId = #{orderId}")
    int deleteByOrderId(int orderId);

    /**
     * 插入订单信息
     * @param orderInfo
     * @return
     */
    int insert(OrderInfo orderInfo);

    /**
     * 插入订单详细信息
     * @param orderDetail
     * @return
     */

    int insertOrderDetail(OrderDetail orderDetail);

    int update(OrderInfo orderInfo);

    @Delete("DELETE FROM order_info WHERE orderId =#{orderId}")
    int deleteById(int orderId);
}
