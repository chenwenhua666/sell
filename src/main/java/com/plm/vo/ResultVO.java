package com.plm.vo;

import lombok.Data;

/**
 * chenwenhua
 * 2018\9\8 0008
 * 20:04
 */
@Data
public class ResultVO<T> {

    private Integer code;

    private String msg;

    private T data;
}
