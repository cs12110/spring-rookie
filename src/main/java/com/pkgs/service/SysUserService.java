package com.pkgs.service;

import com.pkgs.entity.SysUser;
import com.pkgs.mapper.sys.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p/>
 *
 * @author cs12110 created at: 2019/3/6 10:19
 * <p>
 * since: 1.0.0
 */
@Service
public class SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;


    public SysUser findByName(String name) {
        return sysUserMapper.findUserByName(name);
    }
}
