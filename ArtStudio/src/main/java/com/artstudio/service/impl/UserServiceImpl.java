package com.artstudio.service.impl;

import com.artstudio.dao.mapper.UserMapper;
import com.artstudio.dao.pojo.User;
import com.artstudio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: WangPeng
 * @date: 2020/06/13/7:06 下午
 * @description:
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    UserMapper userMapper;

    @Override
    public void addUserService(User user) throws Exception {
        userMapper.addUser(user);
    }

    /**
     * 检查用户名是否重复
     *
     * @param username
     */
    @Override
    public boolean checkService(String username) {
        return userMapper.check(username);
    }

    /**
     * 用户登录
     *
     * @param user
     */
    @Override
    public User loginService(User user) {

        return userMapper.login(user);
    }

    /**
     * 删除用户
     *
     * @param id
     */
    @Override
    public void deleteUserService(int id) {
        userMapper.deleteUser(id);
    }

    /**
     * 更新用户
     *
     * @param user
     */
    @Override
    public void updateUserService(User user) {
        userMapper.updateUser(user);
    }

    /**
     * 查询全部用户
     */
    @Override
    public List<User> findAllUserService() {
        return userMapper.findAllUser();
    }

    /**
     * 根据用户名和角色查询用户
     *
     * @param username
     * @param roleId
     */
    @Override
    public List<User> findUserService(String username, Long roleId) {
        return userMapper.findUser(username, roleId);
    }

    /**
     * 根据id查询用户
     *
     * @param id
     */
    @Override
    public User selectUserByIdService(int id) {
        return userMapper.selectUserById(id);
    }
}
