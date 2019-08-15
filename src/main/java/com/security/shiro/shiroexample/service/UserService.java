package com.security.shiro.shiroexample.service;

import com.security.shiro.shiroexample.bean.User;
import com.security.shiro.shiroexample.dao.UserDao;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @desc: -.
 * @Author: lipei
 * @CreateDate: 2019/8/9 15:23
 * @Version: 1.0
 */
@Service
public class UserService{
    @Resource
    private UserDao dao;
    public User query(){
        User user = dao.selectUser("1");
        return user;
    }

    public List<User> listQuery() {
       List<User> list= dao.selectListUser();
        return list;
    }
}
