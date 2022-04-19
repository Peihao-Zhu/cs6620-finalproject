package com.cqjtu.lexian.persistence;

import com.cqjtu.lexian.domain.SeckillOrder;
import com.cqjtu.lexian.domain.SeckillOrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SeckillOrderRepository  extends JpaRepository<SeckillOrder, Long> {

    @Modifying
    @Query(value = "insert into seckill_order (user_id, goods_id, order_id)values(:#{#order.userId}, :#{#order.goodsId}, :#{#order.orderId})", nativeQuery = true)
    public int insertSeckillOrder(@Param("order") SeckillOrder order);


}
