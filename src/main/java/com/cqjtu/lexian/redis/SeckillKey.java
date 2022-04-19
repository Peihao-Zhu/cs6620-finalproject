package com.cqjtu.lexian.redis;

import com.fasterxml.jackson.databind.ser.Serializers;

public class SeckillKey extends BasePrefix {
    private SeckillKey( int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }
    public static SeckillKey isGoodsOver = new SeckillKey(0, "go");
    public static SeckillKey getMiaoshaPath = new SeckillKey(60, "mp");
    public static SeckillKey getMiaoshaVerifyCode = new SeckillKey(300, "vc");
    public static SeckillKey getMiaoshaVerifyCodeRegister = new SeckillKey(300, "register");
}
