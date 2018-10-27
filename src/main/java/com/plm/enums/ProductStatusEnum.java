package com.plm.enums;

import lombok.Getter;

/**
 * chenwenhua
 * 2018\9\7 0007
 * 16:42
 */
@Getter
public enum ProductStatusEnum implements CodeEnum{
    UP(0,"上架中"),
    DOWN(1,"已下架")
    ;

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
