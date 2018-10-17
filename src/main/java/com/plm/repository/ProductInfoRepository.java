package com.plm.repository;

import com.plm.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * chenwenhua
 * 2018\9\7 0007
 * 16:00
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {

    public List<ProductInfo> findByProductStatus(Integer productStatus);

}
