package com.security.shiro.shiroexample.shiroconfig;

import com.security.shiro.shiroexample.bean.User;
import com.security.shiro.shiroexample.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @desc: -.
 * @Author: lipei
 * @CreateDate: 2019/8/15 16:01
 * @Version: 1.0
 */
 public class MyJdbcRealm extends AuthorizingRealm {
    @Resource
    public UserService userService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Object primaryPrincipal = principals.getPrimaryPrincipal();
        //开始构建权限和角色
        User user = userService.query(primaryPrincipal.toString());
        ArrayList<String> role = new ArrayList<>();
        role.add("user");
        role.add("admin");
        ArrayList<String> strAuth = new ArrayList<>();
        strAuth.add("read");
        strAuth.add("write");
     //WildcardPermission wildcardPermission = new WildcardPermission("user:read");
        WildcardPermission wildcardPermission = new WildcardPermission("1:2");
        SelfAuthorizationInfo selfAuthorizationInfo = new SelfAuthorizationInfo(role,strAuth,Arrays.asList(wildcardPermission));
        return selfAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String password = token.getCredentials().toString();
        String userName = token.getPrincipal().toString();
        User user = userService.query(userName);
        if(user!=null){
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());
            return info;
        }else{
            throw new AccountException("Null usernames are not allowed by this realm.");
        }
    }
}
