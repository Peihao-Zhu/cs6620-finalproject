package com.cqjtu.lexian.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "seckill_order_info")
@Data
public class SeckillOrderInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "goods_id")
    private Long goodsId;
    @Column(name = "delivery_addr_id")
    private Long  deliveryAddrId;
    @Column(name = "goods_name")
    private String goodsName;
    @Column(name = "goods_count")
    private Integer goodsCount;
    @Column(name = "goods_price")
    private Double goodsPrice;
    @Column(name = "order_channel")
    private Integer orderChannel;
    @Column(name = "status")
    private Integer status;
    @Column(name = "create_date")
    private Date createDate;
    @Column(name = "pay_date")
    private Date payDate;
}
