package com.crazyang.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/3/8 上午9:56.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public String getUsers() {
        return "Hello Spring Security";
    }
}
