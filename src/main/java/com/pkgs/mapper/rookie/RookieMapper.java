package com.pkgs.mapper.rookie;

import com.pkgs.entity.RookieEntity;
import org.apache.ibatis.annotations.Param;

/**
 * <p/>
 *
 * @author cs12110 created at: 2019/3/1 14:25
 * <p>
 * since: 1.0.0
 */
public interface RookieMapper {

    /**
     * 新增
     *
     * @param entity entity
     */
    public void insert(RookieEntity entity);


    /**
     * query by id
     *
     * @param id id
     * @return RookieEntity
     */
    public RookieEntity query(@Param("id") Integer id);
}
