package com.artstudio.dao.mapper;

import com.artstudio.dao.pojo.User;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: WangPeng
 * @date: 2020/06/13/11:52 上午
 * @description:
 */
public interface UserMapper {
    /**查询所有用户*/
    List<User> findAllUser();
    /**增加用户*/
    void addUser(User user);
    /**通过用户名核对是否重名*/
    boolean check(String username);
    /**登录*/
    User login(User user);
    /**删除用户*/
    void deleteUser(int id);
    /**根据id查询用户*/
    User selectUserById(int id);
    /**更新用户*/
    void updateUser(User user);
    /**根据用户名和角色模糊搜索*/
    List<User> findUser(String username,Long roleId);
}
