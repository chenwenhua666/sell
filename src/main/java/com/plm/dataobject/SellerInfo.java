package com.plm.dataobject;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * chenwenhua
 * 2018\10\28 0028
 * 11:01
 */
@Data
@Entity
@Table(name = "seller_info")
public class SellerInfo {
    @Id
    private String sellerId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "openid")
    private String openid;

}
