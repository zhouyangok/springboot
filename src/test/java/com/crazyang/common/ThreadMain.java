package com.crazyang.common;

import com.crazyang.dao.UserMapperTest;
import com.crazyang.dao.master.UserMapper;
import com.crazyang.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

/**
 * @ClassName ThreadMain
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/5/10 下午5:02.
 */

public class ThreadMain implements Runnable {

    @Autowired
    private  UserMapper userMapper;

    public static void main(String[] args) {
       Scanner a = new Scanner(System.in);
       Scanner b = new Scanner(System.in);
       int a1 = a.nextInt();
       int b1 = b.nextInt();
        System.out.println(a1);
        System.out.println(b1);
        int c = a1;
        if(c%3==0&&c%5==0){
            System.out.println("满足要求");
        }

    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 10000; i++) {
            System.out.println(Thread.currentThread().getId());
           /* User user = new User();
            user.setUserId(String.valueOf(i*Math.random()));
            user.setName("user" + i);
            user.setPassword("123456");
            userMapper.insert(user);*/
        }
    }

}
