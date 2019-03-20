package com.crazyang.controller;

import com.crazyang.common.baseClass.AjaxObject;
import com.crazyang.entity.OrderInfo;
import com.crazyang.common.baseClass.Page;
import com.crazyang.model.OrderList;
import com.crazyang.service.OrderInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.catalina.manager.util.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName OrderController
 * @Description: 订单类控制层
 * @Author zhouyang
 * @Date 2019/3/20 上午11:39.
 */
@Controller
@RequestMapping("/web/orderInfo")
@Api(value = "Swagger Management System", description = "订单信息控制层")
public class OrderInfoController extends AbstractController {

    @Autowired
    private OrderInfoService orderInfoService;

    @ApiOperation(value = "查看订单信息", response = List.class)
    @GetMapping("/getALl")
    public AjaxObject getAllOrder(Page<OrderInfo> page) {
        List<OrderInfo> orderInfoList = orderInfoService.queryOrderList(page);
        return AjaxObject.ok().put("goodsList", orderInfoList);
    }

    @ApiOperation(value = "根据用户id查询用户订单", response = List.class)
    @GetMapping("/getOrderInfoByUserId/{userId}")
    public AjaxObject getInfoByUserId(@PathVariable("userId") int userId) {
        List<OrderInfo> orderInfos = orderInfoService.findByUserId(userId);
        return AjaxObject.ok().put("orderInfos", orderInfos);
    }

    @ApiOperation(value = "根据订单id查询订单详情")
    @GetMapping("/details/{orderId}")
    public AjaxObject details(@PathVariable("orderId") Integer orderId) {
        OrderList orderList = orderInfoService.findByOrderId(orderId);
        return AjaxObject.ok().put("orderList", orderList);
    }

    @ApiOperation(value = "创建订单")
    @PostMapping("/save")
    public AjaxObject createOrder(OrderList orderList) {
        try {
            orderInfoService.createOrder(orderList);
        } catch (Exception e) {
            logger.info("创建订单失败");
            return AjaxObject.error(1, "创建订单失败");
        }
        logger.info("创建订单成功");
        return AjaxObject.ok();
    }

    @ApiOperation(value = "修改订单信息")
    @PostMapping("/update")
    public AjaxObject update(OrderInfo orderInfo) {
        orderInfoService.update(orderInfo);
        return AjaxObject.ok();
    }

    @ApiOperation(value = "删除订单信息")
    @DeleteMapping("/delete/{orderId}")
    public AjaxObject delete(@PathVariable("orderId") Integer orderId) {
        orderInfoService.deleteById(orderId);
        return AjaxObject.ok();
    }

}
