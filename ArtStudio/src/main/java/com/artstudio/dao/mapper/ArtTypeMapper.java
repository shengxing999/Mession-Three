package com.artstudio.dao.mapper;

import com.artstudio.dao.pojo.ArtType;
import com.artstudio.dao.pojo.Module;

import java.util.List;

public interface ArtTypeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ArtType artType);

    int insertSelective(ArtType artType);

    ArtType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ArtType artType);

    int updateByPrimaryKey(ArtType artType);

    List<ArtType> findAll();

}