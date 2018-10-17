package com.plm.service.impl;

import com.plm.dataobject.ProductInfo;
import com.plm.enums.ProductStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * chenwenhua
 * 2018\9\7 0007
 * 18:51
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {

    @Resource
    private ProductInfoServiceImpl service;

    @Test
    public void findOne() {
        ProductInfo productInfo = service.findOne("123456");
        Assert.assertEquals("123456",productInfo.getProductId());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> list = service.findUpAll();
        Assert.assertNotEquals(0,list.size());
    }

    @Test
    public void findAll() {
        PageRequest pageRequest = PageRequest.of(0,2);
        Page<ProductInfo> productInfoPage = service.findAll(pageRequest);
        System.out.println(productInfoPage.getTotalElements());
        Assert.assertNotEquals(0,productInfoPage.getTotalElements());
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123457");
        productInfo.setProductName("桥头排骨");
        productInfo.setCategoryType(4);
        productInfo.setProductDescription("新鲜排骨");
        productInfo.setProductIcon("http://www.baidu.com");
        productInfo.setProductPrice(new BigDecimal(20.00));
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        productInfo.setProductStock(100);
        ProductInfo result = service.save(productInfo);
        Assert.assertNotNull(result);

    }
}