package com.crazyang.service.impl;

import com.crazyang.dao.LearnResourceMapper;
import com.crazyang.domain.LearnResource;
import com.crazyang.service.LearnService;
import com.crazyang.util.Page;
import com.crazyang.model.LeanQueryLeanListReq;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by tengj on 2017/4/7.
 */
@Service
public class LearnServiceImpl extends BaseService<LearnResource> implements LearnService {

    @Autowired
    private LearnResourceMapper learnResourceMapper;

    @Override
    public void deleteBatch(Long[] ids) {
        Arrays.stream(ids).forEach(id -> learnResourceMapper.deleteByPrimaryKey(id));
    }

    @Override
    public void add(LearnResource resource) {
        learnResourceMapper.add(resource);
    }

    @Override
    public void deleteById(int id) {
        learnResourceMapper.deleteById(id);
    }

    @Override
    public void update(LearnResource resource) {
        learnResourceMapper.update(resource);
    }

    @Override
    public List<LearnResource> queryLearnResouceList(Page<LeanQueryLeanListReq> page) {
        PageHelper.startPage(page.getPage(), page.getRows());
        return learnResourceMapper.queryLearnResouceList(page.getCondition());
    }
}
