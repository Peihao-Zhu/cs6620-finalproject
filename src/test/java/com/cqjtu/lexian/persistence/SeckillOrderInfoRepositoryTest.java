package com.cqjtu.lexian.persistence;

import com.cqjtu.lexian.domain.SeckillOrderInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class SeckillOrderInfoRepositoryTest {

    @Autowired
    SeckillOrderInfoRepository seckillOrderInfoRepository;

    @Test
    void insertOrderInfo() {
        SeckillOrderInfo orderInfo = new SeckillOrderInfo();
        orderInfo.setCreateDate(new Date());
        orderInfo.setDeliveryAddrId(0L);
        orderInfo.setGoodsCount(1);
        orderInfo.setGoodsId(2L);
//        orderInfo.setGoodsName(goods.getGoodsName());
        orderInfo.setGoodsPrice(6.6);
        orderInfo.setOrderChannel(1);
        orderInfo.setStatus(0);
        orderInfo.setUserId(7l);
        orderInfo = seckillOrderInfoRepository.save(orderInfo);
        Assertions.assertEquals(seckillOrderInfoRepository.getOne(orderInfo.getId()).getId(), orderInfo.getId());
        Assertions.assertEquals(seckillOrderInfoRepository.getOne(orderInfo.getId()).getGoodsPrice(), 6.6);
    }
}