package com.cqjtu.lexian.service;

import com.cqjtu.lexian.domain.*;
import com.cqjtu.lexian.persistence.GoodsRepository;
import com.cqjtu.lexian.persistence.SeckillOrderInfoRepository;
import com.cqjtu.lexian.persistence.SeckillOrderRepository;
import com.cqjtu.lexian.redis.OrderKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class SeckillOrderService {

    @Autowired
    private RedisService redisService ;

    @Autowired
    private SeckillOrderRepository orderRepository;

    @Autowired
    private SeckillOrderInfoRepository seckillOrderInfoRepository;

    @Autowired
    private GoodsRepository goodsRepository;

    public SeckillOrder getMiaoshaOrderByUserIdGoodsId(long userId, long goodsId) {
        return	redisService.get(OrderKey.getMiaoshaOrderByUidGid,""+userId+"_"+goodsId, SeckillOrder.class) ;
    }

    @Transactional
    public SeckillOrderInfo createOrder(Customer user, SeckillGoods goods) {
        Goods goods1 = goodsRepository.getOne(Math.toIntExact(goods.getGoodsId()));

        SeckillOrderInfo orderInfo = new SeckillOrderInfo();
        orderInfo.setCreateDate(new Date());
        orderInfo.setDeliveryAddrId(0L);
        orderInfo.setGoodsCount(1);
        orderInfo.setGoodsId(goods.getId());
        orderInfo.setGoodsName(goods1.getName());
        orderInfo.setGoodsPrice(goods.getMiaoshaPrice());
        orderInfo.setOrderChannel(1);
        orderInfo.setStatus(0);
        orderInfo.setUserId(Long.valueOf(user.getCusId()));
        seckillOrderInfoRepository.save(orderInfo);
        // save seckill_order into database
        SeckillOrder seckillOrder = new SeckillOrder();
        seckillOrder.setGoodsId(goods.getId());
        seckillOrder.setOrderId(orderInfo.getId());
        seckillOrder.setUserId(Long.valueOf(user.getCusId()));
        orderRepository.save(seckillOrder);
        redisService.set(OrderKey.getMiaoshaOrderByUidGid,""+user.getNickname()+"_"+goods.getId(), seckillOrder) ;
        return orderInfo;
    }

}
