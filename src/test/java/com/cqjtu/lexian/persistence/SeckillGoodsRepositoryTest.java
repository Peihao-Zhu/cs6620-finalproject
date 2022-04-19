package com.cqjtu.lexian.persistence;

import com.cqjtu.lexian.domain.SeckillGoods;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class SeckillGoodsRepositoryTest {

    @Autowired
    SeckillGoodsRepository seckillGoodsRepository;

    @Test
    void findAll() {
        Assertions.assertEquals(seckillGoodsRepository.findAll().size(), 4);
    }

    @Test
    void getGoodsByGoodsId() {
        Assertions.assertEquals(seckillGoodsRepository.getGoodsByGoodsId(1).getGoodsId(), 1);
    }

    @Test
    void reduceStock() {
        SeckillGoods seckillGoods = new SeckillGoods();
        seckillGoods.setGoodsId(1L);
        seckillGoodsRepository.reduceStock(seckillGoods);
        Assertions.assertEquals(seckillGoodsRepository.getGoodsByGoodsId(1).getStockCount(), 8);
    }
}