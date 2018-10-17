package com.plm.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * chenwenhua
 * 2018\10\14 0014
 * 12:31
 */
@Entity
@Data
public class OrderDetail {
    @Id
    private String detailId;
    private String orderId;
    private String productId;
    private String productName;
    private BigDecimal productPrice;
    private Integer productQuantity;
    private String productIcon;

}
