package com.artstudio.dao.mapper;

import com.artstudio.dao.pojo.Module;
import com.artstudio.dao.pojo.Role;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Role role);

    int insertSelective(Role role);

    Role selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Role role);

    int updateByPrimaryKey(Role role);

    List<Role> findAll();

}