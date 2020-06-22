package com.artstudio.service.impl;

import com.artstudio.dao.mapper.ArtTypeMapper;
import com.artstudio.dao.pojo.ArtType;
import com.artstudio.service.ArtTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: WangPeng
 * @date: 2020/06/19/5:34 下午
 * @description:
 */
@Service("artTypeService")
public class ArtTypeServiceImpl implements ArtTypeService {
    @Autowired(required = false)
    ArtTypeMapper artTypeMapper;
    @Override
    public int deleteByPrimaryKeyService(Long id) {
        return artTypeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertService(ArtType artType) {
        return artTypeMapper.insert(artType);
    }

    @Override
    public int insertSelectiveService(ArtType artType) {
        return artTypeMapper.insertSelective(artType);
    }

    @Override
    public ArtType selectByPrimaryKeyService(Long id) {
        return artTypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelectiveService(ArtType artType) {
        return artTypeMapper.updateByPrimaryKeySelective(artType);
    }

    @Override
    public int updateByPrimaryKeyService(ArtType artType) {
        return artTypeMapper.updateByPrimaryKey(artType);
    }

    @Override
    public List<ArtType> findAllService() {
        return artTypeMapper.findAll();
    }
}
