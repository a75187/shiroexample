package com.security.shiro.shiroexample.shiroconfig;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.PrincipalCollection;
/**
 * @desc: -.
 * @Author: lipei
 * @CreateDate: 2019/8/13 14:41
 * @Version: 1.0
 */

public class UserRealm extends IniRealm {

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
       return super.doGetAuthorizationInfo(principals);
    }


    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        return super.doGetAuthenticationInfo(token);
    }
}
