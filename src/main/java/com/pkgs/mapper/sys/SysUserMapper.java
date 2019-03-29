package com.pkgs.mapper.sys;

import com.pkgs.entity.sys.SysUser;

/**
 * <p/>
 *
 * @author cs12110 created at: 2019/3/6 10:09
 * <p>
 * since: 1.0.0
 */
public interface SysUserMapper {

    /**
     * 根据用户查询出来用户
     *
     * @param userName 用户名称
     * @return SysUser
     */
    SysUser findUserByName(String userName);
}
