package com.pkgs.entity.sys;

import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * TODO:
 *
 * @author cs12110 create at: 2019/3/5 22:16
 * Since: 1.0.0
 */
@Data
public class SysRole {

    private Integer id;

    private String name;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
