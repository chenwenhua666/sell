package com.plm.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * chenwenhua
 * 2018\9\8 0008
 * 20:04
 */
@Data
public class ResultVO<T> implements Serializable {

    private static final long serialVersionUID = -3403908528580331435L;

    private Integer code;

    private String msg;

    private T data;
}
