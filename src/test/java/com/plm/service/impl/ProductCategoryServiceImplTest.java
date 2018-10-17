package com.plm.service.impl;

import com.plm.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * chenwenhua
 * 2018\9\6 0006
 * 19:51
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryServiceImplTest {

    @Autowired
    private ProductCategoryServiceImpl categoryService;

    @Test
    public void findOne() {
        ProductCategory productCategory = categoryService.findOne(2);
        Assert.assertEquals(new Integer(2),productCategory.getCategoryId());
    }

    @Test
    public void findAll() {
        List<ProductCategory> list = categoryService.findAll();
        Assert.assertNotEquals(0,list.size());
    }

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> list = categoryService.findByCategoryTypeIn(Arrays.asList(1, 2, 3, 4));
        Assert.assertNotEquals(0,list.size());
    }

    @Test
    public void save() {
        ProductCategory productCategory = new ProductCategory("热销",6);
        ProductCategory result = categoryService.save(productCategory);
        Assert.assertNotNull(result);
    }
}