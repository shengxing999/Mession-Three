package com.artstudio.service;

import com.artstudio.dao.pojo.Banner;
import com.artstudio.dao.pojo.RoleModule;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: WangPeng
 * @date: 2020/06/19/5:20 下午
 * @description:
 */
public interface RoleModuleService {
    int deleteByPrimaryKeyService(Long id);

    int insertService(RoleModule roleModule);

    int insertSelectiveService(RoleModule roleModule);

    RoleModule selectByPrimaryKeyService(Long id);

    int updateByPrimaryKeySelectiveService(RoleModule roleModule);

    int updateByPrimaryKeyService(RoleModule roleModule);

    List<RoleModule> findAllService();
}
