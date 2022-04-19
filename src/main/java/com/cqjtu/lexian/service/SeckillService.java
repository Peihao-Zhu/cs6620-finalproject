package com.cqjtu.lexian.service;

import com.cqjtu.lexian.domain.Customer;
import com.cqjtu.lexian.domain.SeckillGoods;
import com.cqjtu.lexian.domain.SeckillOrderInfo;
import com.cqjtu.lexian.redis.SeckillKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SeckillService {

    @Autowired
    SeckillGoodService goodsService;

    @Autowired
    SeckillOrderService orderService;
    @Autowired
    RedisService redisService;

    @Transactional
    public SeckillOrderInfo seckill(Customer user, SeckillGoods goods) {
        //减库存 下订单 写入秒杀订单
        boolean success = goodsService.reduceStock(goods);
        if(success){
            return orderService.createOrder(user,goods) ;
        }else {
            //如果库存不存在则内存标记为true
            setGoodsOver(goods.getId());
            return null;
        }
    }

    private void setGoodsOver(Long goodsId) {
        redisService.set(SeckillKey.isGoodsOver, ""+goodsId, true);
    }
}
