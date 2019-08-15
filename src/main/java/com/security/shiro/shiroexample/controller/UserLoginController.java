package com.security.shiro.shiroexample.controller;

import com.security.shiro.shiroexample.bean.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
 import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;


/**
 * @desc: -.
 * @Author: lipei
 * @CreateDate: 2019/8/13 10:47
 * @Version: 1.0
 */
@RestController
@RequestMapping(value = "/open")
public class UserLoginController {

    @GetMapping(value = "/login")
    public String login(User user, HttpServletRequest req){
        Subject subject = SecurityUtils.getSubject();
        // login the subject with a username / password
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        subject.login(token);
        return subject.getPrincipal().toString();
    }

    @GetMapping(value = "/loginOut")
    public String loginOut(HttpServletRequest req){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "success";
    }


}
