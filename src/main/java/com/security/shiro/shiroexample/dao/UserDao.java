package com.security.shiro.shiroexample.dao;

import com.security.shiro.shiroexample.bean.User;

import java.util.List;

/**
 * @desc: -.
 * @Author: lipei
 * @CreateDate: 2019/8/9 11:40
 * @Version: 1.0
 */

public interface UserDao {
    void insertUser(User user);

    User selectUser(String id);

    List<User> selectListUser();
}
