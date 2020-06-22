package com.artstudio.dao.mapper;

import com.artstudio.dao.pojo.Module;
import com.artstudio.dao.pojo.User;

import java.util.List;

/**
 * @author wangpeng
 */
public interface ModuleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Module module);

    int insertSelective(Module module);

    Module selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Module module);

    int updateByPrimaryKey(Module module);

    List<Module> findAll();
}