package com.crazyang.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName SysLog
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/4/11 上午11:16.
 */
@Table(name = "sys_log")
@Entity
@Data
public class SysLog implements Serializable {

    private static final long serialVersionUID = -7252854363243430423L;
    private int userId;
    private String userIp;

    private String userAction;

    private int id;

    private Date createTime;

}
