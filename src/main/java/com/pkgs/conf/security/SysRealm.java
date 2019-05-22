package com.pkgs.conf.security;


import com.pkgs.entity.sys.SysMenu;
import com.pkgs.entity.sys.SysRole;
import com.pkgs.entity.sys.SysUser;
import com.pkgs.service.sys.SysMenuService;
import com.pkgs.service.sys.SysRoleService;
import com.pkgs.service.sys.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 用户登录认证,校权中心
 *
 * <p>
 * reference: <a href="https://segmentfault.com/a/1190000014479154">link</a>
 *
 * @author cs12110 create at: 2019/3/5 21:56
 * Since: 1.0.0
 */
@Component
@Slf4j
public class SysRealm extends AuthorizingRealm {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysMenuService sysMenuService;


    /**
     * 校验用户是否具有访问某一个资源的权限,拦截方法的时候,需要在方法上面添加相应的注解,例如: @RequiresPermissions
     *
     * @param principalCollection {@link PrincipalCollection}
     * @return AuthorizingRealm
     */
    @Override

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        if (null == principalCollection) {
            throw new AuthenticationException("invalid user");
        }

        SysUser sysUser = (SysUser) principalCollection.getPrimaryPrincipal();

        // 判断用户具有该资源的访问权限
        Set<SysRole> sysRoles = sysUser.getSysRoles();
        List<String> roleList = new ArrayList<>(sysRoles.size());
        for (SysRole role : sysRoles) {
            roleList.add(role.getName());
        }

        Set<SysMenu> sysMenus = sysUser.getSysMenus();
        List<String> permList = new ArrayList<>(sysMenus.size());
        for (SysMenu menu : sysMenus) {
            permList.add(menu.getPerms());
        }


        // 主要是这个玩意,有@RequiresPrmissions注解的时候,会被拦截校验
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRoles(roleList);
        info.addStringPermissions(permList);

        return info;
    }

    /**
     * 校验用户是否已经登录
     *
     * @param authenticationToken {@link AuthenticationToken}
     * @return AuthenticationInfo
     * @throws AuthenticationException 权限异常
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String userName = token.getUsername();

        SysUser sysUser = sysUserService.findByName(userName);
        if (null == sysUser) {
            throw new UnknownAccountException("we can't found:" + userName);
        }

        String password = new String(token.getPassword());
        if (!sysUser.getPassword().equals(password)) {
            throw new IncorrectCredentialsException("password not match for this account");
        }

        List<SysRole> roleList = sysRoleService.findRolesByUser(sysUser.getId());

        // 登录成功,从数据库获取用户角色和用户角色对应的课访问资源
        Set<SysRole> roles = new HashSet<>(roleList);
        Set<SysMenu> menus = new HashSet<>();
        for (SysRole role : roles) {
            List<SysMenu> sysMenus = sysMenuService.queryByRole(role.getId());
            menus.addAll(sysMenus);
        }

        sysUser.setSysRoles(roles);
        sysUser.setSysMenus(menus);

        return new SimpleAuthenticationInfo(sysUser, sysUser.getPassword(), sysUser.getName());
    }
}
