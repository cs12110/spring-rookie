package com.pkgs.service.sys;

import com.pkgs.entity.sys.SysMenu;
import com.pkgs.mapper.sys.SysMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p/>
 *
 * @author cs12110 created at: 2019/3/6 11:20
 * <p>
 * since: 1.0.0
 */
@Service
public class SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;


    public List<SysMenu> queryByRole(Integer roleId) {
        return sysMenuMapper.findMenuByRole(roleId);
    }
}
