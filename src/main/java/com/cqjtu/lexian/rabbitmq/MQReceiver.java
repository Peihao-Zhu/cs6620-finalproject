package com.cqjtu.lexian.rabbitmq;

import com.cqjtu.lexian.domain.Customer;
import com.cqjtu.lexian.domain.SeckillGoods;
import com.cqjtu.lexian.domain.SeckillOrder;
import com.cqjtu.lexian.service.RedisService;
import com.cqjtu.lexian.service.SeckillGoodService;
import com.cqjtu.lexian.service.SeckillOrderService;
import com.cqjtu.lexian.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MQReceiver {

    private static Logger log = LoggerFactory.getLogger(MQReceiver.class);

    @Autowired
    RedisService redisService;

    @Autowired
    SeckillGoodService goodsService;

    @Autowired
    SeckillOrderService orderService;

    @Autowired
    SeckillService seckillService;


    @RabbitListener(queues=MQConfig.SECKILL_QUEUE)
    public void receive(String message) {
        log.info("receive message:"+message);
        SeckillMessage mm  = RedisService.stringToBean(message, SeckillMessage.class);
        Customer user = mm.getUser();
        long goodsId = mm.getGoodsId();

        SeckillGoods goods = goodsService.getGoodsByGoodsId(goodsId);
        int stock = goods.getStockCount();
        if(stock <= 0) {
            return;
        }
        //判断是否已经秒杀到了
        SeckillOrder order = orderService.getMiaoshaOrderByUserIdGoodsId(Long.valueOf(user.getCusId()), goodsId);
        if(order != null) {
            return;
        }
        //减库存 下订单 写入秒杀订单
        seckillService.seckill(user, goods);
    }

}
