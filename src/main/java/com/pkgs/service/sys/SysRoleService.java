package com.pkgs.service.sys;

import com.pkgs.entity.sys.SysRole;
import com.pkgs.mapper.sys.SysRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p/>
 *
 * @author cs12110 created at: 2019/3/6 10:35
 * <p>
 * since: 1.0.0
 */
@Service
public class SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;


    @Cacheable(key = "'role_query_'+#{userId}")
    public List<SysRole> findRolesByUser(Integer userId) {
        return sysRoleMapper.findRoleByUser(userId);
    }
}
