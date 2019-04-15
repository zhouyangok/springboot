package com.crazyang.service.impl;

import com.crazyang.common.baseClass.Page;
import com.crazyang.dao.master.GoodsMapper;
import com.crazyang.entity.Goods;
import com.crazyang.service.GoodsService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName GoodsServiceImpl
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/3/8 下午4:59.
 */
@Service
public class GoodsServiceImpl extends BaseService<Goods> implements GoodsService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private GoodsMapper goodsMapper;

    /**
     * @param
     * @return
     * @Cacheable 应用到读取数据的方法上，先从缓存中读取，如果没有再从DB获取数据，然后把数据添加到缓存中
     * key 缓存在redis中的key
     * unless 表示条件表达式成立的话不放入缓存
     */
    @Override
    public List<Goods> queryGoodsList(Page<Goods> page) {
        PageHelper.startPage(page.getPage(), page.getRows());
        return goodsMapper.queryGoodsList(page.getCondition());
    }

    @Override
    public Goods findById(int goodsId) {
        String goodsKey = String.valueOf(goodsId);
        Goods goods = (Goods) redisTemplate.opsForValue().get(goodsKey);
        if (goods == null) {
            Goods newGoods = goodsMapper.getOne(goodsId);
//            redisTemplate.opsForValue().set(goodsKey, newGoods);
            redisTemplate.opsForValue().set(goodsKey,newGoods,5L, TimeUnit.MINUTES);
            return newGoods;
        }
        return goods;
    }

    @Override
    public Goods findByName(String goodsName) {
        return goodsMapper.findByName(goodsName);
    }

    @Override
    public int insert(Goods goods) {
        return goodsMapper.insert(goods);
    }

    @Override
    public int update(Goods goods) {
        String goodsKey = String.valueOf(goods.getGoodsId());
        redisTemplate.delete(goodsKey);
        return goodsMapper.update(goods);
    }

    @Override
    public int deleteById(int goodsId) {
        String goodsKey = String.valueOf(goodsId);
        redisTemplate.delete(goodsKey);
        return goodsMapper.deleteById(goodsId);
    }
}
