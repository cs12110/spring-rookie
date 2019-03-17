package com.pkgs.mapper.sys;

import com.pkgs.entity.sys.SysRole;

import java.util.List;

/**
 * <p/>
 *
 * @author cs12110 created at: 2019/3/6 10:09
 * <p>
 * since: 1.0.0
 */
public interface SysRoleMapper {

    /**
     * 根据用户查询角色
     *
     * @param userId 用户id
     * @return SysUser
     */
    public List<SysRole> findRoleByUser(Integer userId);
}
