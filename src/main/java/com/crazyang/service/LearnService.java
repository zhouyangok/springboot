package com.crazyang.service;

import com.crazyang.entity.LearnResource;
import com.crazyang.common.baseClass.Page;
import com.crazyang.model.LeanQueryLeanListReq;

import java.util.List;

/**
 * @ClassName LearnService
 * @Description: 学习服务层接口
 * @Author zhouyang
 * @Date 2019/3/8 上午11:16.
 */

public interface LearnService  extends IService<LearnResource>{
     List<LearnResource> queryLearnResourceList(Page<LeanQueryLeanListReq> page);

     void deleteBatch(Long[] ids);

    void addResource(LearnResource resource);

    void deleteById(int id);

    void update(LearnResource resource);
}
