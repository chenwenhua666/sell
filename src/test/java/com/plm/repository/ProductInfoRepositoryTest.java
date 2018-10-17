package com.plm.repository;

import com.plm.dataobject.ProductInfo;
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
 * 2018\9\7 0007
 * 16:04
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Resource
    private ProductInfoRepository repository;

    @Test
    public void saveTest(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("豆腐脑");
        productInfo.setCategoryType(4);
        productInfo.setProductDescription("新鲜豆腐脑");
        productInfo.setProductIcon("http://www.baidu.com");
        productInfo.setProductPrice(new BigDecimal(8.00));
        productInfo.setProductStatus(0);
        productInfo.setProductStock(100);
        ProductInfo result = repository.save(productInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByProductStatus() {
        List<ProductInfo> result = repository.findByProductStatus(0);
        Assert.assertNotEquals(0,result.size());
    }
}