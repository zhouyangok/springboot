package com.crazyang.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName Permission
 * @Description: 用户信息实体类
 * @Author zhouyang
 * @Date 2019/3/4 下午3:19.
 */

/**
 * 使用@Data注释，省略getter，setter方法
 *
 * @NotNull://CharSequence, Collection, Map 和 Array 对象不能是 null, 但可以是空集（size = 0）。  
 * @NotEmpty://CharSequence, Collection, Map 和 Array 对象不能是 null 并且相关对象的 size 大于 0。  
 * @NotBlank://String 不是 null 且去除两端空白字符后的长度（trimmed length）大于 0。
 */
@Table(name = "user")
@Entity
@Data
public class User implements Serializable{

    private static final long serialVersionUID = 9175490794572613853L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String userId;

    @NotBlank
    private String name;

    private String phone;

    private String address;

    @NotBlank
    private String password;

    private String email;

    private int sex;

    private int status;

    private Date createTime;

    private Date updateTime;

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return passwrod
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}