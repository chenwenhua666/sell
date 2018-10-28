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
@RequestMapping("seller")
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

}
