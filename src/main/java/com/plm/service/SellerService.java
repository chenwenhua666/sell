package com.plm.service;

import com.plm.dataobject.SellerInfo;

/**
 * chenwenhua
 * 2018\10\28 0028
 * 11:16
 */
public interface SellerService {

    SellerInfo findSellerInfoByOpenid(String openid);
}
