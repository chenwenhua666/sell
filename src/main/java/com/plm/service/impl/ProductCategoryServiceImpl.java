package com.plm.service.impl;

import com.plm.dataobject.ProductCategory;
import com.plm.repository.ProductCategoryRepository;
import com.plm.service.ProductCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * chenwenhua
 * 2018\9\6 0006
 * 19:47
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Resource
    private ProductCategoryRepository repository;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        return repository.findById(categoryId).orElse(null);
    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return repository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }
}
