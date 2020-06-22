package com.artstudio.service.impl;

import com.artstudio.dao.mapper.ModuleMapper;
import com.artstudio.dao.pojo.Module;
import com.artstudio.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: WangPeng
 * @date: 2020/06/19/5:36 下午
 * @description:
 */
@Service("moduleService")
public class ModuleServiceImpl implements ModuleService {
    @Autowired(required = false)
    ModuleMapper moduleMapper;
    @Override
    public int deleteByPrimaryKeyService(Long id) {
        return moduleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertService(Module module) {
        return moduleMapper.insert(module);
    }

    @Override
    public int insertSelectiveService(Module module) {
        return moduleMapper.insertSelective(module);
    }

    @Override
    public Module selectByPrimaryKeyService(Long id) {
        return moduleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelectiveService(Module module) {
        return moduleMapper.updateByPrimaryKeySelective(module);
    }

    @Override
    public int updateByPrimaryKeyService(Module module) {
        return moduleMapper.updateByPrimaryKey(module);
    }

    @Override
    public List<Module> findAllService() {
        return moduleMapper.findAll();
    }
}
