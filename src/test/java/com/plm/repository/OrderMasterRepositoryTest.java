package com.plm.repository;

import com.plm.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * chenwenhua
 * 2018\10\14 0014
 * 12:51
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {
    @Resource
    private OrderMasterRepository repository;

    @Test
    public void testSave(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("2");
        orderMaster.setBuyerAddress("新罗大街");
        orderMaster.setBuyerName("华");
        orderMaster.setBuyerPhone("123456");
        orderMaster.setBuyerOpenid("110");
        orderMaster.setOrderAmount(new BigDecimal(1.2));
        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByBuyerOpenid() {

        Page<OrderMaster> result = repository.findByBuyerOpenid("110",PageRequest.of(0,3));
        Assert.assertNotEquals(0,result.getTotalElements());
    }
}