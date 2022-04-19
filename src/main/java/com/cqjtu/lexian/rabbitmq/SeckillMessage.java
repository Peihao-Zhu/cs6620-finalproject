package com.cqjtu.lexian.rabbitmq;

import com.cqjtu.lexian.domain.Customer;

public class SeckillMessage {
    private Customer user;
    private long goodsId;
    public Customer getUser() {
        return user;
    }
    public void setUser(Customer user) {
        this.user = user;
    }
    public long getGoodsId() {
        return goodsId;
    }
    public void setGoodsId(long goodsId) {
        this.goodsId = goodsId;
    }
}
