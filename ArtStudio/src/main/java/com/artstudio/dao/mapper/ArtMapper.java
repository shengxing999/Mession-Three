package com.artstudio.dao.mapper;

import com.artstudio.dao.pojo.Art;
import com.artstudio.dao.pojo.Module;

import java.util.List;

public interface ArtMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Art art);

    int insertSelective(Art art);

    Art selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Art art);

    int updateByPrimaryKey(Art art);

    List<Art> findAll();

}