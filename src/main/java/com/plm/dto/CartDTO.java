package com.plm.dto;

import lombok.Data;

/**
 * chenwenhua
 * 2018\10\17 0017
 * 21:44
 */
@Data
public class CartDTO {

    /**
     * 商品ID
     */
    private String productId;
    /**
     * 商品数量
     */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
