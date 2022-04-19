package com.cqjtu.lexian.persistence;

import com.cqjtu.lexian.domain.SeckillOrder;
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
class SeckillOrderRepositoryTest {

    @Autowired
    SeckillOrderRepository seckillOrderRepository;

    @Test
    void insertSeckillOrder() {
        SeckillOrder seckillOrder = new SeckillOrder();
        seckillOrder.setGoodsId(8L);
        seckillOrder.setOrderId(1550L);
        seckillOrder.setUserId(7L);
        seckillOrder = seckillOrderRepository.save(seckillOrder);
//        seckillOrderRepository.insertSeckillOrder(seckillOrder);
        Assertions.assertEquals(seckillOrderRepository.getOne(seckillOrder.getId()).getId(), seckillOrder.getId());

        Assertions.assertEquals(seckillOrderRepository.getOne(seckillOrder.getId()).getGoodsId(), 8L);

    }

}