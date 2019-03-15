package com.crazyang.service.impl;

import com.crazyang.core.util.Page;
import com.crazyang.entity.Goods;
import com.crazyang.entity.User;
import com.crazyang.service.GoodsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @ClassName GoodsServiceImplTest
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/3/8 下午5:02.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsServiceImplTest {

    @Autowired
    private GoodsService goodsService;

    @Test
    public void queryGoodsList() throws Exception {
        Page<Goods> page = new Page<>();
        List <Goods> goodsList = goodsService.queryGoodsList(page);
        System.out.println(goodsList.size());
    }

    @Test
    public void getOne() throws Exception {
    }

    @Test
    public void findByName() throws Exception {
        Goods goods = goodsService.findByName("你很好");
        System.out.println(goods.getGoodsName());

    }

    @Test
    public void insert() throws Exception {
        Date date = new Date();
        Goods goods = new Goods();
        goods.setGoodsSn("ceshi2");
        goods.setGoodsName("手机");
        goods.setProductNo("120012");
        System.out.println(date);
        goods.setCreateTime(date);
        int result = goodsService.insert(goods);
        System.out.println(result);
    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void deleteById() throws Exception {
    }

}