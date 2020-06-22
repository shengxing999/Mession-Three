package com.artstudio.dao.mapper;

import com.artstudio.dao.pojo.Module;
import com.artstudio.dao.pojo.RoleModule;

import java.util.List;

public interface RoleModuleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RoleModule roleModule);

    int insertSelective(RoleModule roleModule);

    RoleModule selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoleModule roleModule);

    int updateByPrimaryKey(RoleModule roleModule);

    List<RoleModule> findAll();
}