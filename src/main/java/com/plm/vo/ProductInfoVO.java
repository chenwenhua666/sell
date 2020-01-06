package com.plm.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * chenwenhua
 * 2018\9\8 0008
 * 20:29
 */
@Data
public class ProductInfoVO implements Serializable {

    private static final long serialVersionUID = 8573650346618072893L;

    @JsonProperty("id")
    private String productId;

    @JsonProperty("name")
    private String productName;

    @JsonProperty("price")
    private BigDecimal productPrice;

    @JsonProperty("description")
    private String productDescription;

    @JsonProperty("icon")
    private String productIcon;

}
