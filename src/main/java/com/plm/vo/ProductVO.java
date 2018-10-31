package com.plm.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * chenwenhua
 * 2018\9\8 0008
 * 20:24
 */
@Data
public class ProductVO implements Serializable {

    private static final long serialVersionUID = -7482406264494956607L;

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
