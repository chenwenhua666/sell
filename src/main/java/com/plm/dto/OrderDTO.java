package com.plm.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.plm.dataobject.OrderDetail;
import com.plm.utils.serializer.DateToLongSerializer;
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
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {
    private String orderId;
    private String buyerName;
    private String buyerPhone;
    private String buyerAddress;
    private String buyerOpenid;
    private BigDecimal orderAmount;
    private Integer orderStatus;
    private Integer payStatus;
    @JsonSerialize(using = DateToLongSerializer.class)
    private Date createTime;
    @JsonSerialize(using = DateToLongSerializer.class)
    private Date updateTime;
    private List<OrderDetail> orderDetailList;
}
