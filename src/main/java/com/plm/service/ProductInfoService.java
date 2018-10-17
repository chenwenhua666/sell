package com.plm.service;

import com.plm.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * chenwenhua
 * 2018\9\7 0007
 * 16:30
 */
public interface ProductInfoService {

    public ProductInfo findOne(String ProductId);

    public List<ProductInfo> findUpAll();

    public Page<ProductInfo> findAll(Pageable pageable);

    public  ProductInfo save(ProductInfo productInfo);

}
