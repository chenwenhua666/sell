package com.plm.handler;

import com.plm.config.ProjectUrlConfig;
import com.plm.exception.HttpStatusException;
import com.plm.exception.SellException;
import com.plm.exception.SellerAuthorizeException;
import com.plm.utils.ResultVOUtil;
import com.plm.vo.ResultVO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * @author : cwh
 * 2018/10/30 0030
 * description ：
 */
@ControllerAdvice
public class SellExceptionHandler {

    @Resource
    private ProjectUrlConfig urlConfig;
    //拦截登录异常
    //http://sell.natapp4.cc/sell/wechat/qrAuthorize?returnUrl=http://sell.natapp4.cc/sell/seller/login
    @ExceptionHandler(value = SellerAuthorizeException.class)
    public ModelAndView handlerAuthorizeException(){
        /*return new ModelAndView("redirect:"
                .concat(urlConfig.getWechatOpenAuthorize())
                .concat("/sell/wechat/qrAuthorize")
                .concat("?returnUrl=")
                .concat(urlConfig.getSell())
                .concat("/sell/seller/login"));*/
        return new ModelAndView("redirect:"+"http://127.0.0.1:8080/sell/seller/login?openid=110");
    }

    @ExceptionHandler(value = SellException.class)
    @ResponseBody
    public ResultVO handlerSellException(SellException e){
        return ResultVOUtil.error(e.getCode(),e.getMessage());
    }

    @ExceptionHandler(value = HttpStatusException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void httpStatusException(){

    }


};
