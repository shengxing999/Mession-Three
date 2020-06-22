package com.artstudio.dao.pojo;

import org.hibernate.validator.constraints.Length;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: WangPeng
 * @date: 2020/06/13/11:21 上午
 * @description:
 */
public class User {
    private long id;
    @Length(min=5,max=12,message="用户名为5到12位的字符串")
    private String username;
    @Length(min=6,max=12,message="密码必须为6到12位的字符串")
    private String pwd;

    private long roleId;
    private long createAt;
    private long createBy;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(long createAt) {
        this.createAt = createAt;
    }

    public long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(long createBy) {
        this.createBy = createBy;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                ", roleId=" + roleId +
                ", createAt=" + createAt +
                ", createBy=" + createBy +
                '}';
    }

    public User() {
    }
}
