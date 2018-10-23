package com.plm.service.impl;

import com.plm.dto.OrderDTO;
import com.plm.service.OrderService;
import com.plm.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * chenwenhua
 * 2018\10\23 0023
 * 20:23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PayServiceImplTest {
    @Autowired
    private PayService payService;

    @Autowired
    private OrderService orderService;

    @Test
    public void create() {

        OrderDTO orderDTO  = orderService.fondOne("1539868802693464679");
        payService.create(orderDTO);
    }
}