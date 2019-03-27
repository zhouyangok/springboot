package com.crazyang.service.impl;

import com.crazyang.common.exception.BusinessException;
import com.crazyang.common.baseClass.Page;
import com.crazyang.entity.Goods;
import com.crazyang.service.GoodsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

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
        long begin = System.currentTimeMillis();
        List<Goods> goodsList = goodsService.queryGoodsList(page);
        System.out.println(goodsList.size());
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }

    @Test
    public void getOne() throws Exception {
        Goods goods = goodsService.findById(1);
        System.out.println(goods.getGoodsName());
    }

    @Test
    public void findByName() throws Exception {
        Goods goods = goodsService.findByName("你很好");
        System.out.println(goods.getClass());

    }

    @Test
    public void insert() throws Exception {
        Date date = new Date();
        for (int i = 0; i < 10; i++) {
            Goods goods = new Goods();
            goods.setGoodsSn("ceshi2" + i);
            goods.setGoodsName("redis" + i);
            goods.setProductNo("101" + i);
            goods.setCreateTime(date);
            Goods res = goodsService.findByName(goods.getGoodsName());
            if(res!=null){
                throw new BusinessException("该商品已存在");
            }
        }
    }

    @Test
    public void update() throws Exception {
        Goods goods = new Goods();
        goods.setGoodsId(2);
        goods.setGoodsName("redisChange");
        goods.setProductNo("003232");
        int result = goodsService.update(goods);
        System.out.println(result);

    }

    @Test
    public void deleteById() throws Exception {

    }

}