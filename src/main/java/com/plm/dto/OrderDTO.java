package com.plm.dto;

import com.plm.dataobject.OrderDetail;
import com.plm.enums.OrderStatusEnum;
import com.plm.enums.PayStatusEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * chenwenhua
 * 2018\10\16 0016
 * 21:01
 */
@Data
public class OrderDTO {
    private String orderId;
    private String buyerName;
    private String buyerPhone;
    private String buyerAddress;
    private String buyerOpenid;
    private BigDecimal orderAmount;
    private Integer orderStatus;
    private Integer payStatus;
    private Date createTime;
    private Date updateTime;
    private List<OrderDetail> orderDetailList;
}
