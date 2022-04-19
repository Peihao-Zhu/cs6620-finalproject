package com.cqjtu.lexian.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "seckill_goods")
@Data
public class SeckillGoods {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "miaosha_price")
    private Double miaoshaPrice;

    @Column(name = "goods_id")
    private Long goodsId;

    @Column(name = "stock_count")
    private Integer stockCount;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;
}
