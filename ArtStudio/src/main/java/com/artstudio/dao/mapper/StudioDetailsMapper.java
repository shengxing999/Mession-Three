package com.artstudio.dao.mapper;

import com.artstudio.dao.pojo.Module;
import com.artstudio.dao.pojo.StudioDetails;

import java.util.List;

public interface StudioDetailsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(StudioDetails studioDetails);

    int insertSelective(StudioDetails studioDetails);

    StudioDetails selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(StudioDetails studioDetails);

    int updateByPrimaryKey(StudioDetails studioDetails);

    List<StudioDetails> findAll();
}