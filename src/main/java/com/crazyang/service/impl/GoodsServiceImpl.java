package com.crazyang.service.impl;

import com.crazyang.core.util.Page;
import com.crazyang.dao.GoodsMapper;
import com.crazyang.entity.Goods;
import com.crazyang.entity.User;
import com.crazyang.service.GoodsService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName GoodsServiceImpl
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/3/8 下午4:59.
 */
@Service
public class GoodsServiceImpl extends BaseService<Goods> implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;
    @Override
    public List<Goods> queryGoodsList(Page<Goods> page) {
        PageHelper.startPage(page.getPage(), page.getRows());
        return goodsMapper.queryGoodsList(page.getCondition());
    }

    @Override
    public Goods getOne(int goodsId) {
        return null;
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
        return 0;
    }

    @Override
    public int deleteById(int goodsId) {
        return 0;
    }
}
