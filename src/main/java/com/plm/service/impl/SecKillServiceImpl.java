package com.plm.service.impl;

import com.plm.exception.SellException;
import com.plm.service.RedisLock;
import com.plm.service.SecKillService;
import com.plm.utils.KeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * chenwenhua
 * 2018\10\30 0030
 * 20:30
 */
@Service
public class SecKillServiceImpl implements SecKillService {
    private static final int TIMEOUT = 100 * 1000;//超时时间10s

    @Autowired
    private RedisLock redisLock;

    static Map<String,Integer> products;
    static Map<String,Integer> stock;
    static Map<String,String> orders;
    static{
        /**
         * 模拟多个表，商品信息表，库存表、秒杀成功订单表
         */
        products = new HashMap<>();
        stock = new HashMap<>();
        orders = new HashMap<>();
        products.put("123456",100000);
        stock.put("123456",100000);
    }

    private String queryMap(String productId){
        return "双十一活动，特价商品，限量份"
                + products.get(productId)
                + "还剩： "+ stock.get(productId) + " 份"
                + "该商品成功下单用户数目："
                + orders.size()+ " 人";
    }

    @Override
    public String querySecKillProductInfo(String productId) {
        return this.queryMap(productId);
    }

    @Override
    public void orderProductMockDiffUser(String productId) {
        //加锁
        Long time = System.currentTimeMillis() + TIMEOUT;
        if (!redisLock.lock(productId,String.valueOf(time))){
            throw new SellException(101,"稍等。。");
        }
        //1、查询该商品库存，为0则活动结束。
        int stockNum = stock.get(productId);
        if (stockNum == 0){
            throw new SellException(100,"活动结束");
        } else {
            //2、下单（模拟不同用户）
            orders.put(KeyUtil.getUniqueKey(),productId);
            //3、减库存
            stockNum = stockNum - 1;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            stock.put(productId,stockNum);
        }
        redisLock.unlock(productId,String.valueOf(time));

    }
}
