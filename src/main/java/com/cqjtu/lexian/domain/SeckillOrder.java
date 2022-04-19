package com.cqjtu.lexian.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "seckill_order")
@Data
public class SeckillOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "order_id")
    private Long  orderId;

    @Column(name = "goods_id")
    private Long goodsId;
}
