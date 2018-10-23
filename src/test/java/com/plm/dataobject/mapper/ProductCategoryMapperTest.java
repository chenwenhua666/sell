package com.plm.dataobject.mapper;

import com.plm.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author : cwh
 * 2018/10/23 0023
 * description ：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryMapperTest {

    @Resource
    private ProductCategoryMapper mapper;

    @Test
    public void insertByMap() {
        Map<String,Object> map = new HashMap<>();
        map.put("categoryName","美食");
        map.put("category_type",2);
        int result = mapper.insertByMap(map);
        Assert.assertEquals(1,result);
    }

    @Test
    public void insertByObject(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("外卖");
        productCategory.setCategoryType(4);
        int result = mapper.insertByObject(productCategory);
        Assert.assertEquals(1,result);
    }
    @Test
    public void findByCategoryType(){
        ProductCategory productCategory = mapper.findByCategoryType(1);
        Assert.assertNotNull(productCategory);
    }

    @Test
    public void findByCategoryName(){
        List<ProductCategory> productCategoryList = mapper.findByCategoryName("外卖");
        Assert.assertNotEquals(0,productCategoryList.size());
    }

    @Test
    public  void updateByCategoryType (){
        int result = mapper.updateByCategoryType("特价",1);
        Assert.assertEquals(1,result);
    }

    @Test
    public void updateByObejct (){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("热点");
        productCategory.setCategoryType(1);
        int result = mapper.updateByObject(productCategory);
        Assert.assertEquals(1,result);
    }

    @Test
    public void deleteByCategoryType(){
        int result = mapper.deleteByCategoryType(2);
        Assert.assertEquals(1,result);
    }

    @Test
    public void selectByCategoryType(){
       ProductCategory productCategory = mapper.selectByCategoryType(1);
       Assert.assertNotNull(productCategory);
    }

}