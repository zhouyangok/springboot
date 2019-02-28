package com.crazyang.dao;

import com.crazyang.domain.LearnResource;
import com.crazyang.util.MyMapper;

import java.util.List;
import java.util.Map;

public interface LearnResourceMapper extends MyMapper<LearnResource> {
    List<LearnResource> queryLearnResouceList(Map<String,Object> map);

    void add(LearnResource resource);

    void update(LearnResource resource);

    void deleteById(int id);
}