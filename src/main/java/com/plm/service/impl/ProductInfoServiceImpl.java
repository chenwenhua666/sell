package com.plm.service.impl;

import com.plm.dataobject.ProductInfo;
import com.plm.enums.ProductStatusEnum;
import com.plm.repository.ProductInfoRepository;
import com.plm.service.ProductInfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * chenwenhua
 * 2018\9\7 0007
 * 16:34
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Resource
    private ProductInfoRepository repository;

    @Override
    public ProductInfo findOne(String ProductId) {
        return repository.findById(ProductId).orElse(null);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }
}
