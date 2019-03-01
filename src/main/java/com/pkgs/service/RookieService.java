package com.pkgs.service;

import com.pkgs.entity.RookieEntity;
import com.pkgs.mapper.rookie.RookieMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p/>
 *
 * @author cs12110 created at: 2019/3/1 14:40
 * <p>
 * since: 1.0.0
 */
@Service
@Slf4j
public class RookieService {

    @Autowired
    private RookieMapper rookieMapper;


    public RookieEntity queryById(Integer id) {
        return rookieMapper.query(id);
    }


    @Transactional(rollbackFor = Exception.class)
    public Integer insert(RookieEntity entity) {

        rookieMapper.insert(entity);

        if ("admin".equals(entity.getName())) {
            throw new IllegalArgumentException("Disallow to be admin");
        }

        return entity.getId();
    }

    @Cacheable(cacheNames = "rookie", key = "#id")
    public RookieEntity searchWithCache(Integer id) {

        log.info("Search with id:{}", id);

        RookieEntity entity = new RookieEntity();
        entity.setName("name" + id);
        entity.setId(id);

        return entity;
    }

}
