package com.plm.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * @author : cwh
 * 2018/10/31 0031
 * description ：
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
        if (!StringUtils.isEmpty(currentValue) && Long.parseLong(currentValue) < System.currentTimeMillis()){
            String oldValue = stringRedisTemplate.opsForValue().getAndSet(key,value);
            if (!StringUtils.isEmpty(oldValue) && oldValue.equals(currentValue)) {
                return true;
            }
        }

        return false;
    }

}
