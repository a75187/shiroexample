package com.security.shiro.shiroexample.shiroconfig;

import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;

import java.util.Collection;
import java.util.List;


/**
 * @desc: 自定义权限关系
 * @Author: lipei
 * @CreateDate: 2019/8/16 10:29
 * @Version: 1.0
 */

public class SelfAuthorizationInfo implements AuthorizationInfo {
    private List<String> roles;
    private List<String> stringPermissions;
    private  List<Permission>  permission;
    public SelfAuthorizationInfo(List<String> roles,List<String> stringPermissions,List<Permission> permission) {
            this.stringPermissions=stringPermissions;
            this.roles=roles;
            this.permission=permission;
    }

    @Override
    public Collection<String> getRoles() {
        return roles;
    }

    @Override
    public Collection<String> getStringPermissions() {
        return stringPermissions;
    }

    @Override
    public Collection<Permission> getObjectPermissions() {
        return permission;
    }

}
