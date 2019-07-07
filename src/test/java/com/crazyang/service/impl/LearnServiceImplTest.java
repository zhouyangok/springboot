package com.crazyang.service.impl;

import com.crazyang.dao.master.LearnResourceMapper;
import com.crazyang.entity.LearnResource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @ClassName LearnServiceImplTest
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/5/14 下午5:32.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class LearnServiceImplTest {

    @Autowired
    private LearnResourceMapper learnResourceMapper;

    @Test
    public void add() throws Exception {
       long start = System.currentTimeMillis();
       //单线程插入10000条数据，共花费178403毫秒
        for(int i =0;i<10000;i++){
            LearnResource learnResource = new LearnResource();
            learnResource.setAuthor("author"+i);
            learnResource.setTitle("title"+i);
            learnResource.setUrl("http://www.baidu.com"+i);
            learnResourceMapper.insertResource(learnResource);
        }
        //开启十个线程，插入数据
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

}