package com.security.shiro.shiroexample.controller.security;

import com.security.shiro.shiroexample.bean.User;
import com.security.shiro.shiroexample.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @desc: -.
 * @Author: lipei
 * @CreateDate: 2019/8/9 10:03
 * @Version: 1.0
 */
@RestController()
@RequestMapping(value = "/security")
public class UserController {
    @Resource
    private UserService service;

    @GetMapping(value = "/pickUserName")
    public String pickUserName(HttpServletRequest req){
        return  SecurityUtils.getSubject().getPrincipal().toString();
    }

    @GetMapping(value = "/pickPassword")
    @RequiresRoles("admin")
    public String pickPassword(HttpServletRequest req){
        Subject subject = SecurityUtils.getSubject();
        if(subject.getPrincipal()==null){
            throw new RuntimeException("未登陆");
        }
        return   subject.getPrincipal().toString();
    }

//一下jdbc 领域实现

    @GetMapping("/query")
    public String query(){
        return  service.query().toString();
    };


    @GetMapping("/listQuery")
    //IniRealm模式下使用此注解需要debug在用户权限信息中手动加入
    @RequiresPermissions("user")
    public String listQuery(){
        String perm = "printer:print:laserjet4400n1111111111111";
        if(SecurityUtils.getSubject().isPermitted(perm)){
            List<User> users = service.listQuery();
            return users.toString();
        } else {
         return null;
        }

    };
}
