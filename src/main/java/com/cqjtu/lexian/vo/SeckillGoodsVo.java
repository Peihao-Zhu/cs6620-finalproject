package com.cqjtu.lexian.vo;

import lombok.Data;

import java.util.Date;

@Data
public class SeckillGoodsVo {
    private Double miaoshaPrice;
    private Integer stockCount;
    private Date startDate;
    private Date endDate;
}
