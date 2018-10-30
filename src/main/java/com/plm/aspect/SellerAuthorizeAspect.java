package com.plm.aspect;

import com.plm.constant.CookieConstant;
import com.plm.constant.RedisConstant;
import com.plm.exception.SellerAuthorizeException;
import com.plm.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import static org.springframework.web.context.request.RequestContextHolder.getRequestAttributes;

/**
 * @author : cwh
 * 2018/10/30 0030
 * description ：
 */

@Component
@Aspect
@Slf4j
public class SellerAuthorizeAspect {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Pointcut("execution(public * com.plm.controller.Seller*.*(..))" +
    "&& !execution(public * com.plm.controller.SellerUserController.*(..))")
    public void verity(){};

    @Before("verity()")
    public void doVerify() {
        log.info("进入身份验证verity");
        /*ServletRequestAttributes requestAttributes =  (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        Cookie cookie = CookieUtil.get(request,CookieConstant.TOKEN);
        if (cookie == null) {
            log.warn("【登录校验】Cookie中查不到token");
            throw new SellerAuthorizeException();
        }
        String tokenValue = stringRedisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX, cookie.getValue()));
        if (StringUtils.isEmpty(tokenValue)) {
            log.warn("【登录校验】Redis中查不到token");
            throw new SellerAuthorizeException();
        }*/


    }

}
