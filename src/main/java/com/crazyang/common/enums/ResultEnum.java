package com.crazyang.common.enums;

import lombok.Getter;

/**
 * @ClassName OrderStatusEnum
 * @Description: 结果枚举
 * @Author zhouyang
 * @Date 2019/3/27 上午10:52.
 */
@Getter
public enum ResultEnum {

    SUCCESS(0,"成功"),

    PARAMS_ERROR(1, "参数不正确"),

    PRODUCT_NOT_EXIST(10, "商品不存在"),
    PRODUCT_STOCK_ERROR(11, "商品库存不足"),
    ORDER_NOT_EXIST(12, "订单不存在"),
    ORDER_DETAIL_NOT_EXIST(13, "订单详情不存在"),
    ORDER_STATUS_ERROR(14, "订单状态不正确"),
    ORDER_UPDATE_FAIL(15, "订单更新失败"),
    ORDER_DETAIL_EMPTY(16, "订单详情为空"),
    ORDER_PAID_STATUS_ERROR(17, "订单支付状态不正确"),
    CART_EMPTY(18, "购物车为空"),
    ORDER_OWNER_ERROR(19, "该订单不属于当前用户"),
    WECHAT_MP_ERROR(20,"微信公纵账号方面错误"),
    WXPAY_NOTIFY_MONEY_VERIFY_ERROR(21,"微信支付异步通知金额校验不通过"),

    ORDER_CANCEL_SUCCESS(22,"订单取消成功"),
    ORDER_FINISH_SUCCESS(23,"订单完结成功"),
    PRODUCT_STATUS_ERROR(24,"商品状态不正确"),
    PRODUCT_ONSALE_SUCCESS(25,"商品上架成功"),
    PRODUCT_OFFSALE_SUCCESS(26,"上下架成功"),
    WECHAT_QRERROR(27,"微信开放平台账号方面错误"),
    LOGIN_FAIL(28,"登录失败，登录信息不正确"),
    LOGOUT_SUCCESS(29,"登出成功"),
    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
