package com.crazyang.common;

import com.crazyang.common.utils.MD5Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @ClassName UserPasswordTest
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/3/20 上午9:30.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class UserPasswordTest {

    @Test
    public void generatePassword(){
        String password = "admin";
        System.out.println(MD5Utils.getResult(password));
    }

}
