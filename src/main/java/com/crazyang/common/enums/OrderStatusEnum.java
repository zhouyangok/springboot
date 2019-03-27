package com.crazyang.common.enums;

import lombok.Getter;

/**
 * @ClassName OrderStatusEnum
 * @Description: 订单状态
 * @Author zhouyang
 * @Date 2019/3/27 上午10:52.
 */
@Getter
public enum OrderStatusEnum implements CodeEnum<Integer> {

    NEW(0, "新下单"),
    FINISH(1, "已完成"),
    CANCEL(2, "已取消"),;

    private Integer code;
    private String msg;

    OrderStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    @Override
    public Integer getCode() {
        return this.code;
    }
}
