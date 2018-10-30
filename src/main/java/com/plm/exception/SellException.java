package com.plm.exception;

import com.plm.enums.ResultEnum;
import lombok.Getter;

/**
 * chenwenhua
 * 2018\10\17 0017
 * 19:27
 */
@Getter
public class SellException extends RuntimeException{

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code,String message) {
        super(message);
        this.code = code;
    }
}
