package com.cqjtu.lexian.service;

import com.cqjtu.lexian.domain.SeckillGoods;
import com.cqjtu.lexian.persistence.SeckillGoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeckillGoodService {
    @Autowired
    SeckillGoodsRepository seckillGoodsRepository;

    public List<SeckillGoods> findAll() {
        return seckillGoodsRepository.findAll();
    }

    public SeckillGoods getGoodsByGoodsId(long goodsId) {
        return seckillGoodsRepository.getGoodsByGoodsId(goodsId);
    }

//    use optimistic locking to reduce stock
    public boolean reduceStock(SeckillGoods goods) {
        int ret = seckillGoodsRepository.reduceStock(goods);
        return ret > 0;
    }

}


