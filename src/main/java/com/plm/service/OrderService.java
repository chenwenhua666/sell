package com.plm.service;

import com.plm.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * chenwenhua
 * 2018\10\16 0016
 * 21:03
 */
public interface OrderService {

    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    OrderDTO create(OrderDTO orderDTO);

    /**
     * 查询单个订单
     * @param orderId
     * @return
     */
    OrderDTO fondOne(String orderId);

    /*查询订单列表*/
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);

    /*取消订单*/
    OrderDTO cancel(OrderDTO orderDTO);
    /*完结订单*/
    OrderDTO finish(OrderDTO orderDTO);
    /*支付订单*/
    OrderDTO paid(OrderDTO orderDTO);

}
