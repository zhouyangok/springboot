package com.crazyang.dao.master;

import com.crazyang.common.baseClass.MyMapper;
import com.crazyang.entity.Goods;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @ClassName GoodsMapper
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/3/8 下午4:42.
 */
@Component
public interface GoodsMapper extends MyMapper<Goods> {

    List<Goods> queryGoodsList(Map<String, Object> map);

    @Select("SELECT * FROM goods WHERE goodsId=#{goodsId}")
    Goods getOne(int goodsId);

    @Select("SELECT * FROM goods WHERE goodsName=#{goodsName}")
    Goods findByName(String goodsName);

    int insert(Goods goods);


    int update(Goods goods);

    @Delete("DELETE FROM goods WHERE goodsId =#{goodId}")
    int deleteById(int goodsId);
}
