package com.crazyang.service;

import com.crazyang.entity.LearnResource;
import com.crazyang.core.util.Page;
import com.crazyang.model.LeanQueryLeanListReq;

import java.util.List;

/**
 * Created by tengj on 2017/4/7.
 */

public interface LearnService  extends IService<LearnResource>{
     List<LearnResource> queryLearnResouceList(Page<LeanQueryLeanListReq> page);

     void deleteBatch(Long[] ids);

    void add(LearnResource resource);

    void deleteById(int id);

    void update(LearnResource resource);
}
