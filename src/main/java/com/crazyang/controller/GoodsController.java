package com.crazyang.controller;

import com.crazyang.common.baseClass.AjaxObject;
import com.crazyang.common.baseClass.Page;
import com.crazyang.entity.Goods;
import com.crazyang.service.GoodsService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @ClassName GoodsController
 * @Description: 商品控制层
 * @Author zhouyang
 * @Date 2019/3/15 上午11:26.
 */
@RestController
@RequestMapping("/web/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ApiOperation(value = "获取所有的商品")
    @RequestMapping("/goodsList")
    public AjaxObject queryGoodsList() throws Exception {
        Page<Goods> page = new Page<>();
        long begin = System.currentTimeMillis();
        System.out.println(begin);
        List<Goods> goodsList = goodsService.queryGoodsList(page);
        System.out.println(goodsList.size());
        long end = System.currentTimeMillis();
        System.out.println(end);
        System.out.println(end - begin);
        return AjaxObject.ok().put("goodsList", goodsList);
    }

    @ApiOperation(value = "根据id获取山炮信息")
    @GetMapping("/findById/{goodsId}")
    public AjaxObject findById(@PathVariable("goodsId") int goodsId) {
        Goods goods = goodsService.findById(goodsId);
        return AjaxObject.ok().put("goods", goods);
    }

    @RequestMapping("/findByName")
    public AjaxObject findByName(@RequestParam("name") String name) {
        Goods goods = goodsService.findByName(name);
        return AjaxObject.ok().put("goods", goods);
    }

    @RequestMapping("/save")
    public AjaxObject save() {
        Date date = new Date();
        Goods goods = new Goods();
        goods.setGoodsSn("ceshi2");
        goods.setGoodsName("redis");
        goods.setProductNo("101");
        goods.setCreateTime(date);
        Goods res = goodsService.findByName(goods.getGoodsName());
        if (res != null) {
            logger.info("添加失败，"+goods.getGoodsName()+"已存在");
            return AjaxObject.error(1, "用户已存在");
        }
        goodsService.insert(goods);
        return AjaxObject.ok();
    }

    @RequestMapping("/update")
    public AjaxObject update(@RequestParam("goodsId") Integer goodsId) {
        Goods goods = new Goods();
        goods.setGoodsId(goodsId);
        goods.setGoodsName("rchange1");
        goods.setProductNo("003232");
        try {
            goodsService.update(goods);
        } catch (Exception e) {
            return AjaxObject.error(e.getMessage());
        }

        return AjaxObject.ok();
    }

    @RequestMapping("/delete/{id}")
    public AjaxObject delete(@PathVariable int id) {
        int delStatus = goodsService.deleteById(id);
        return AjaxObject.ok().put("delete", delStatus);
    }

}
