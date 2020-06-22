package com.artstudio.service;

import com.artstudio.dao.pojo.Module;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: WangPeng
 * @date: 2020/06/19/5:19 下午
 * @description:
 */
public interface ModuleService {
    int deleteByPrimaryKeyService(Long id);

    int insertService(Module module);

    int insertSelectiveService(Module module);

    Module selectByPrimaryKeyService(Long id);

    int updateByPrimaryKeySelectiveService(Module module);

    int updateByPrimaryKeyService(Module module);

    List<Module> findAllService();
}
