shiro权限实现 sql和postmen位于resources目录下

权限集合由组权限加个人权限并集

权限定义在 MyJdbcRealm.doGetAuthorizationInfo中 目前写死  调试权限时修改相关rows和auths以及 WildcardPermission 权限组
 
@RequiresPermissions的注解实现是  WildcardPermission类  其作用是  默认使用此细粒度的权限实现
 相关测试都在Controller中