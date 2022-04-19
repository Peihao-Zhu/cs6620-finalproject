package com.cqjtu.lexian.persistence;

import com.cqjtu.lexian.domain.SeckillOrder;
import com.cqjtu.lexian.domain.SeckillOrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SeckillOrderInfoRepository extends JpaRepository<SeckillOrderInfo, Long> {

    @Modifying
    @Query(value = "insert into order_info(user_id, goods_id, goods_name, goods_count, goods_price, order_channel, status, create_date)values("
            + ":#{#orderInfo.userId}, :#{#orderInfo.goodsId}, :#{#orderInfo.goodsName}, :#{#orderInfo.goodsCount}, :#{#orderInfo.goodsPrice}, :#{#orderInfo.orderChannel},:#{#orderInfo.status}, :#{#orderInfo.createDate} )", nativeQuery = true)
    public long insertOrderInfo(@Param("orderInfo") SeckillOrderInfo orderInfo);
}
