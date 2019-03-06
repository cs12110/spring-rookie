package com.pkgs.entity;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.Set;

/**
 * TODO:
 *
 * @author cs12110 create at: 2019/3/5 21:38
 * Since: 1.0.0
 */
@Data
public class SysUser {

    private Integer id;

    private String name;

    private String password;

    private Set<SysRole> sysRoles;
    private Set<SysMenu> sysMenus;


    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
