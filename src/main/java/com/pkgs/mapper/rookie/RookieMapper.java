package com.pkgs.mapper.rookie;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pkgs.entity.rookie.RookieEntity;
import org.apache.ibatis.annotations.Param;

/**
 * <p/>
 *
 * @author cs12110 created at: 2019/3/1 14:25
 * <p>
 * since: 1.0.0
 */
public interface RookieMapper extends BaseMapper<RookieEntity> {

    /**
     * 新增
     *
     * @param entity entity
     * @return int num
     */
    @Override
    public int insert(RookieEntity entity);


    /**
     * query by id
     *
     * @param id id
     * @return RookieEntity
     */
    public RookieEntity query(@Param("id") Integer id);
}
