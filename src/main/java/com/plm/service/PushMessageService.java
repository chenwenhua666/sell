package com.plm.service;

import com.plm.dto.OrderDTO;

/**
 * @author : cwh
 * 2018/10/30 0030
 * description ：消息推送
 */
public interface PushMessageService {

    /**
     * 订单状态变更消息
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);
}
