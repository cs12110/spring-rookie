package com.pkgs.entity;

import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * <p/>
 *
 * @author cs12110 created at: 2019/3/1 13:41
 * <p>
 * since: 1.0.0
 */
@Data
public class RookieEntity {

    private Integer id;

    private String name;

    private String level;


    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
