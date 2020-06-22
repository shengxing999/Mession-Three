package com.artstudio.service.impl;

import com.artstudio.dao.mapper.ArtMapper;
import com.artstudio.dao.pojo.Art;
import com.artstudio.service.ArtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: WangPeng
 * @date: 2020/06/19/5:33 下午
 * @description:
 */
@Service("artService")
public class ArtServiceImpl implements ArtService {
    @Autowired(required = false)
    ArtMapper artMapper;
    @Override
    public int deleteByPrimaryKeyService(Long id) {
        return artMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertService(Art art) {
        return artMapper.insert(art);
    }

    @Override
    public int insertSelectiveService(Art art) {
        return artMapper.insertSelective(art);
    }

    @Override
    public Art selectByPrimaryKeyService(Long id) {
        return artMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelectiveService(Art art) {
        return artMapper.updateByPrimaryKeySelective(art);
    }

    @Override
    public int updateByPrimaryKeyService(Art art) {
        return artMapper.updateByPrimaryKey(art);
    }

    @Override
    public List<Art> findAllService() {
        return artMapper.findAll();
    }
}
