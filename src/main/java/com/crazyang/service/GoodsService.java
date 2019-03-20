package com.crazyang.service;

import com.crazyang.common.baseClass.Page;
import com.crazyang.entity.Goods;

import java.util.List;

/**
 * @ClassName GoodsService
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/3/8 下午4:57.
 */

public interface GoodsService extends IService<Goods> {

    List<Goods> queryGoodsList(Page<Goods> page);

    Goods getOne(int goodsId);

    Goods findByName(String goodsName);

    int insert(Goods goods);


    int update(Goods goods);

    int deleteById(int goodsId);
}
