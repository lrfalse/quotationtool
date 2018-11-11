package com.commons.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @Notes: job 公共方法
 * @Author: At
 * @Date: 2018/3/26
 */
public abstract class BaseJob {

    private final Logger LOG = LoggerFactory.getLogger(BaseJob.class);

    @Autowired
    private RedisTemplate redisTemplate;

    public Logger getLOG() {
        return LOG;
    }

    public RedisTemplate getRedisTemplate() {
        return redisTemplate;
    }
}
