package com.artstudio.service.impl;

import com.artstudio.dao.mapper.RoleModuleMapper;
import com.artstudio.dao.pojo.RoleModule;
import com.artstudio.service.RoleModuleService;
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
@Service("roleModuleService")
public class RoleModuleServiceImpl implements RoleModuleService {
    @Autowired(required = false)
    RoleModuleMapper roleModuleMapper;
    @Override
    public int deleteByPrimaryKeyService(Long id) {
        return roleModuleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertService(RoleModule roleModule) {
        return roleModuleMapper.insert(roleModule);
    }

    @Override
    public int insertSelectiveService(RoleModule roleModule) {
        return roleModuleMapper.insertSelective(roleModule);
    }

    @Override
    public RoleModule selectByPrimaryKeyService(Long id) {
        return roleModuleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelectiveService(RoleModule roleModule) {
        return roleModuleMapper.updateByPrimaryKeySelective(roleModule);
    }

    @Override
    public int updateByPrimaryKeyService(RoleModule roleModule) {
        return roleModuleMapper.updateByPrimaryKey(roleModule);
    }

    @Override
    public List<RoleModule> findAllService() {
        return roleModuleMapper.findAll();
    }
}
