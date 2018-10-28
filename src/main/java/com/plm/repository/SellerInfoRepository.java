package com.plm.repository;

import com.plm.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * chenwenhua
 * 2018\10\28 0028
 * 11:07
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo,String> {

    SellerInfo findByOpenid(String openid);

}
