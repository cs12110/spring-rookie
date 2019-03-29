package com.pkgs.mapper.sys;

import com.pkgs.entity.sys.SysMenu;

import java.util.List;

/**
 * <p/>
 *
 * @author cs12110 created at: 2019/3/6 10:09
 * <p>
 * since: 1.0.0
 */
public interface SysMenuMapper {

    /**
     * 根据用户查询角色
     *
     * @param roleId 角色id
     * @return list
     */
    List<SysMenu> findMenuByRole(Integer roleId);
}
