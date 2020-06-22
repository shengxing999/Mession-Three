package com.artstudio.service;

import com.artstudio.dao.pojo.Banner;
import com.artstudio.dao.pojo.Role;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: WangPeng
 * @date: 2020/06/19/5:20 下午
 * @description:
 */
public interface RoleService {
    int deleteByPrimaryKeyService(Long id);

    int insertService(Role role);

    int insertSelectiveService(Role role);

    Role selectByPrimaryKeyService(Long id);

    int updateByPrimaryKeySelectiveService(Role role);

    int updateByPrimaryKeyService(Role role);

    List<Role> findAllService();
}
