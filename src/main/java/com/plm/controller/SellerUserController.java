package com.plm.controller;

import com.plm.config.ProjectUrlConfig;
import com.plm.constant.CookieConstant;
import com.plm.constant.RedisConstant;
import com.plm.dataobject.SellerInfo;
import com.plm.enums.ResultEnum;
import com.plm.service.SellerService;
import com.plm.utils.CookieUtil;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * chenwenhua
 * 2018\10\28 0028
 * 12:32
 */
@Controller
@RequestMapping("/seller")
public class SellerUserController {
    @Resource
    private SellerService sellerService;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private ProjectUrlConfig urlConfig;

    @GetMapping("/login")
    public ModelAndView login(@RequestParam("openid") String openid,
                              Map<String,Object> map,
                              HttpServletResponse response){
        SellerInfo sellerInfo = sellerService.findSellerInfoByOpenid(openid);
        if (sellerInfo == null) {
            map.put("msg", ResultEnum.LOGIN_FAIL.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error", map);
        }

        //2、设置token至redis
        String token = UUID.randomUUID().toString();
        Integer expire = RedisConstant.EXPIRE;
        stringRedisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX,token),openid,expire,TimeUnit.SECONDS);

        //3、设置token到cookie
        CookieUtil.set(response,CookieConstant.TOKEN,token,CookieConstant.EXPIRE);
        return new ModelAndView("redirect:" + urlConfig.getSell() + "/sell/seller/order/list");
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request,HttpServletResponse response,
                       Map<String,Object> map){
        //1、从cookie里查询
        Cookie cookie = CookieUtil.get(request,CookieConstant.TOKEN);
        //2、清除redis
        if (cookie != null) {
            stringRedisTemplate.opsForValue().getOperations()
                .delete(String.format(RedisConstant.TOKEN_PREFIX,cookie.getValue()));
            //3、清除cookie
            CookieUtil.set(response,CookieConstant.TOKEN,null,0);
        }
        map.put("msg",ResultEnum.LOGOUT_SUCCESS.getMessage());
        map.put("url", "/sell/seller/order/list");
        return new ModelAndView("common/success", map);
    }

}
