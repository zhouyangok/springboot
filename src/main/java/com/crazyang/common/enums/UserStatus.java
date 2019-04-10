package com.crazyang.common.enums;


import lombok.Getter;

@Getter
public enum UserStatus implements CodeEnum<Integer> {

    NEW(0,"用户已存在"),

    DISABLE(1,"用户被禁用"),

    USEABLE(2,"用户被激活"),;

    private Integer code;
    private String msg;

    UserStatus(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    @Override
    public Integer getCode() {
        return this.code;
    }
}
