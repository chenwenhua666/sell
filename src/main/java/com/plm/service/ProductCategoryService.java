package com.plm.service;

import com.plm.dataobject.ProductCategory;

import java.util.List;

/**
 * chenwenhua
 * 2018\9\6 0006
 * 19:41
 */
public interface ProductCategoryService {

    public ProductCategory findOne(Integer categoryId);

    public List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    public ProductCategory save(ProductCategory productCategory);

}
