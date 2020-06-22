package com.artstudio.service.impl;

import com.artstudio.dao.mapper.RoleMapper;
import com.artstudio.dao.pojo.Role;
import com.artstudio.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: WangPeng
 * @date: 2020/06/19/5:37 下午
 * @description:
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Autowired(required = false)
    RoleMapper roleMapper;
    @Override
    public int deleteByPrimaryKeyService(Long id) {
        return roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertService(Role role) {
        return roleMapper.insert(role);
    }

    @Override
    public int insertSelectiveService(Role role) {
        return roleMapper.insertSelective(role);
    }

    @Override
    public Role selectByPrimaryKeyService(Long id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelectiveService(Role role) {
        return roleMapper.updateByPrimaryKeySelective(role);
    }

    @Override
    public int updateByPrimaryKeyService(Role role) {
        return roleMapper.updateByPrimaryKey(role);
    }

    @Override
    public List<Role> findAllService() {
        return roleMapper.findAll();
    }
}
