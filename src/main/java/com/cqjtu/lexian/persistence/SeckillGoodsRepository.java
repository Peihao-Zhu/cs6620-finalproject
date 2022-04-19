package com.cqjtu.lexian.persistence;

import com.cqjtu.lexian.domain.Goods;
import com.cqjtu.lexian.domain.SeckillGoods;
import com.cqjtu.lexian.vo.SeckillGoodsVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SeckillGoodsRepository extends JpaRepository<SeckillGoods, Long> {

    @Override
    List<SeckillGoods> findAll();

    @Query(value = "select * from seckill_goods mg where mg.goods_id = ?1", nativeQuery = true)
    SeckillGoods getGoodsByGoodsId(long goodsId);

    @Modifying
    @Query(value = "update seckill_goods set stock_count = stock_count - 1 where goods_id = :#{#goods.goodsId} and stock_count > 0", nativeQuery = true)
    public int reduceStock(@Param("goods") SeckillGoods goods);

}
