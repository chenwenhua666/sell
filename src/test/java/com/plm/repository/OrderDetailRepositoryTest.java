package com.plm.repository;

import com.plm.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * chenwenhua
 * 2018\10\14 0014
 * 13:25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Resource
    private OrderDetailRepository repository;

    @Test
    public void testSave() throws  Exception{
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("2");
        orderDetail.setOrderId("123");
        orderDetail.setProductId("p1");
        orderDetail.setProductName("凉面");
        orderDetail.setProductPrice(new BigDecimal(5));
        orderDetail.setProductQuantity(10);
        orderDetail.setProductIcon("www.baidu.com");

        OrderDetail result = repository.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOrderId() {
        List<OrderDetail> result = repository.findByOrderId("123");
        Assert.assertNotEquals(0,result.size());
    }
}