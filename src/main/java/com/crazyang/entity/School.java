package com.crazyang.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @ClassName School
 * @Description: 学校实体类
 * @Author zhouyang
 * @Date 2019/4/15 下午5:27.
 */

@Table(name = "school")
@Data
@Entity
public class School implements Serializable {

    private static final long serialVersionUID = 900005175753675864L;

    private int id;

    private String schoolName;

    private String schoolDescribe;
}
