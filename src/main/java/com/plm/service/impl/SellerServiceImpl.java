package com.plm.service.impl;

import com.plm.dataobject.SellerInfo;
import com.plm.repository.SellerInfoRepository;
import com.plm.service.SellerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * chenwenhua
 * 2018\10\28 0028
 * 11:17
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Resource
    private SellerInfoRepository repository;


    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return repository.findByOpenid(openid);
    }
}
