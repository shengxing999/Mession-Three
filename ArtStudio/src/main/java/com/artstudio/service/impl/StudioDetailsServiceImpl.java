package com.artstudio.service.impl;

import com.artstudio.dao.mapper.StudioDetailsMapper;
import com.artstudio.dao.pojo.StudioDetails;
import com.artstudio.service.StudioDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: WangPeng
 * @date: 2020/06/19/5:38 下午
 * @description:
 */
@Service("studioDetailsService")
public class StudioDetailsServiceImpl implements StudioDetailsService {
    @Autowired(required = false)
    StudioDetailsMapper studioDetailsMapper;
    @Override
    public int deleteByPrimaryKeyService(Long id) {
        return studioDetailsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertService(StudioDetails studioDetails) {
        return studioDetailsMapper.insert(studioDetails);
    }

    @Override
    public int insertSelectiveService(StudioDetails studioDetails) {
        return studioDetailsMapper.insertSelective(studioDetails);
    }

    @Override
    public StudioDetails selectByPrimaryKeyService(Long id) {
        return studioDetailsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelectiveService(StudioDetails studioDetails) {
        return studioDetailsMapper.updateByPrimaryKeySelective(studioDetails);
    }

    @Override
    public int updateByPrimaryKeyService(StudioDetails studioDetails) {
        return studioDetailsMapper.updateByPrimaryKey(studioDetails);
    }

    @Override
    public List<StudioDetails> findAllService() {
        return studioDetailsMapper.findAll();
    }
}
