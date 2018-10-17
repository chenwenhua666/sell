package com.plm.repository;

import com.plm.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

/**
 * chenwenhua
 * 2018\9\6 0006
 * 16:19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Resource
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest(){
        ProductCategory productCategory = repository.findById(1).orElse(null);
        System.out.println(productCategory.toString());
    }

    @Test
    @Transactional
    public void saveTest(){
        ProductCategory productCategory = new ProductCategory("热销",6);
        ProductCategory result = repository.save(productCategory);
        Assert.assertNotNull(result);
       // Assert.assertNotEquals(null,result);
    }

    @Test
    public void findAndSaveTest(){
        ProductCategory productCategory = repository.findById(2).orElse(null);
        productCategory.setCategoryType(4);
        repository.save(productCategory);
    }

    @Test
    public void findByCategoryTypeInTest(){
        List<Integer> list = Arrays.asList(3,4,5);
        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result.size());
    }

}