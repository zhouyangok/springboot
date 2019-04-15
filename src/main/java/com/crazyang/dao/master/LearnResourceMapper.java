package com.crazyang.dao.master;

import com.crazyang.entity.LearnResource;
import com.crazyang.common.baseClass.MyMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface LearnResourceMapper extends MyMapper<LearnResource> {
    List<LearnResource> queryLearnResourceList(Map<String, Object> map);

    void add(LearnResource resource);

    void update(LearnResource resource);

    void deleteById(int id);
}