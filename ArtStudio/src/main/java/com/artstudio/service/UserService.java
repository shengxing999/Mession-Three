package com.artstudio.service;

import com.artstudio.dao.pojo.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: WangPeng
 * @date: 2020/06/13/4:40 下午
 * @description:
 */
public interface UserService {
    /**
     * 添加新用户
     */
    void addUserService(User user) throws Exception;

    /**
     * 检查用户名是否重复
     */
    boolean checkService(String username);

    /**
     * 用户登录
     */
    User loginService(User user);

    /**
     * 删除用户
     */
    void deleteUserService(int id);

    /**
     * 更新用户
     */
    void updateUserService(User user);

    /**
     * 查询全部用户
     */
    List<User> findAllUserService();

    /**
     * 根据用户名和角色查询用户
     */
    List<User> findUserService(String username, Long roleId);

    /**
     * 根据id查询用户
     */
    User selectUserByIdService(int id);

}
