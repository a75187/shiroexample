package com.security.shiro.shiroexample.bean;

import java.util.Date;

/**
 * @desc: -.
 * @Author: lipei
 * @CreateDate: 2019/8/9 10:48
 * @Version: 1.0
 */

public class User {

    private String username;


    private String password;


    private String email;


    private String type;


    private Date updatetim;


    private Date regdate;


    private Integer isDelete;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getUpdatetim() {
        return updatetim;
    }

    public void setUpdatetim(Date updatetim) {
        this.updatetim = updatetim;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public Integer getDelete() {
        return isDelete;
    }

    public void setDelete(Integer delete) {
        isDelete = delete;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", type='" + type + '\'' +
                ", updatetim=" + updatetim +
                ", regdate=" + regdate +
                ", isDelete=" + isDelete +
                '}';
    }
}
