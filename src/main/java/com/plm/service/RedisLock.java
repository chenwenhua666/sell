package com.plm.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * chenwenhua
 * 2018\10\31 0031
 * 19:32
 */
@Component
@Slf4j
public class RedisLock {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    public boolean lock(String key,String value){
        if (stringRedisTemplate.opsForValue().setIfAbsent(key,value)){
            return true;
        }
        String currentValue = stringRedisTemplate.opsForValue().get(key);
        if (!StringUtils.isEmpty(currentValue)
            && Long.parseLong(currentValue) < System.currentTimeMillis()){
            String oldValue = stringRedisTemplate.opsForValue().getAndSet(key,value);
            if (!StringUtils.isEmpty(oldValue) && oldValue.equals(currentValue)){
                return true;
            }
        }
        return false;
    }

    public void unlock(String key,String value){
        try {
            String currentValue = stringRedisTemplate.opsForValue().get(key);
            if (!StringUtils.isEmpty(currentValue) && currentValue.equals(value)){
                stringRedisTemplate.opsForValue().getOperations().delete(key);
            }
        } catch (Exception e){
            log.error("解锁异常,{}",e);
        }
    }


}
