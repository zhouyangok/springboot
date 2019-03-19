package com.crazyang.service.impl;

import com.crazyang.entity.Goods;
import com.crazyang.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName RedisTest
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/3/16 下午6:54.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void redisTest() {
        // redi s存储数据
        String key = "name";
        redisTemplate.opsForValue().set(key, "redisName");
        // 获取数据
        String value = (String) redisTemplate.opsForValue().get(key);
        System.out.println("获取缓存中key为" + key + "的值为：" + value);

        Goods goods = new Goods();
        goods.setGoodsName("redisTest");
        goods.setProductNo("101001");
        String goodsKey = "goods-Key";
        redisTemplate.opsForValue().set(goodsKey, goods);
        Goods newGoods = (Goods) redisTemplate.opsForValue().get(goodsKey);
        System.out.println("获取缓存中key为" + goods + "的值为：" + newGoods);

    }
}
