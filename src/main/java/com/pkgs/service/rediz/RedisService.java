package com.pkgs.service.rediz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

/**
 * redis 操作
 * <p>
 * <p/>
 *
 * @author cs12110 created at: 2019/3/6 16:36
 * <p>
 * since: 1.0.0
 */
@Service
public class RedisService {

    @Autowired
    private RedisTemplate<String, String> template;


    /**
     * set, just like: `set haiyan value1`
     *
     * @param key   key
     * @param value value
     */
    public void set(String key, String value) {
        ValueOperations<String, String> operations = template.opsForValue();
        operations.set(key, value);
    }


    /**
     * 获取value
     *
     * @param key key
     * @return String
     */
    public String get(String key) {
        ValueOperations<String, String> operations = template.opsForValue();
        return operations.get(key);
    }

    /**
     * 队列头部添加元素
     *
     * @param key   key
     * @param value value
     */
    public void leftPush(String key, String value) {
        ListOperations<String, String> operations = template.opsForList();
        operations.leftPush(key, value);
    }

    /**
     * 移除队列尾部元素
     *
     * @param key key
     * @return String
     */
    public String rightPop(String key) {
        ListOperations<String, String> operations = template.opsForList();
        return operations.rightPop(key);
    }


    /**
     * hset
     *
     * @param key   key
     * @param field field
     * @param value value
     */
    public void hset(String key, String field, String value) {
        HashOperations<String, String, String> operations = template.opsForHash();
        operations.put(key, field, value);
    }

    /**
     * hget
     *
     * @param key   key
     * @param field field
     * @return String
     */
    public String hget(String key, String field) {
        HashOperations<String, String, String> operations = template.opsForHash();
        return operations.get(key, field);
    }

    /**
     * set add
     *
     * @param key   key
     * @param value value
     */
    public void sadd(String key, String value) {
        SetOperations<String, String> operations = template.opsForSet();
        operations.add(key, value);
    }

    /**
     * set pop
     *
     * @param key key
     * @return String
     */
    public String spop(String key) {
        SetOperations<String, String> operations = template.opsForSet();
        return operations.pop(key);
    }

    /**
     * zadd
     *
     * @param key   key
     * @param value value
     * @param score score
     */
    public void zadd(String key, String value, double score) {
        ZSetOperations<String, String> operations = template.opsForZSet();
        operations.add(key, value, score);
    }

}
