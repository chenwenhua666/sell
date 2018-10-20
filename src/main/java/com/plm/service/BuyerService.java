package com.plm.service;

import com.plm.dto.OrderDTO;

/**
 * chenwenhua
 * 2018\10\20 0020
 * 15:32
 */
public interface BuyerService {
    /**
     * 查询一个订单
     * @param openid
     * @param orderId
     * @return
     */
    OrderDTO findOrderOne(String openid,String orderId);

    //取消订单
    OrderDTO cancelOrder(String openid,String orderId);

}
