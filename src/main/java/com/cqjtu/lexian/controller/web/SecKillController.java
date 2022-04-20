package com.cqjtu.lexian.controller.web;

import com.cqjtu.lexian.common.Response;
import com.cqjtu.lexian.domain.Customer;
import com.cqjtu.lexian.domain.SeckillGoods;
import com.cqjtu.lexian.domain.SeckillOrder;
import com.cqjtu.lexian.rabbitmq.MQSender;
import com.cqjtu.lexian.rabbitmq.SeckillMessage;
import com.cqjtu.lexian.redis.GoodsKey;
import com.cqjtu.lexian.service.GoodsService;
import com.cqjtu.lexian.service.RedisService;
import com.cqjtu.lexian.service.SeckillOrderService;
import com.cqjtu.lexian.service.SeckillGoodService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

import static com.cqjtu.lexian.common.ResultStatus.*;

@Controller
public class SecKillController  implements InitializingBean {

    @Autowired
    GoodsService goodsService;

    @Autowired
    SeckillGoodService seckillGoodService;

    @Autowired
    RedisService redisService;

    @Autowired
    SeckillOrderService seckillOrderService;

    @Autowired
    MQSender mqSender;

    @RequestMapping(value="/do_seckill", method= RequestMethod.POST)
    @ResponseBody
    public Response miaosha(HttpSession session,
                            @RequestParam("goodsId") long goodsId) {
        Response response = Response.isSuccess();
        Customer user = (Customer) session.getAttribute("customer");
        if (user == null) {
            response.setMsg(SESSION_ERROR.getMessage());
            response.setStatus(SESSION_ERROR.getCode());
            return response;
        }

        //是否已经秒杀到
        SeckillOrder order = seckillOrderService.getMiaoshaOrderByUserIdGoodsId(Long.valueOf(user.getCusId()), goodsId);
        if (order != null) {
            response.setMsg(REPEATE_MIAOSHA.getMessage());
            response.setStatus(REPEATE_MIAOSHA.getCode());
            return response;
        }
        // reduce stock in redis
        Long stock = redisService.decr(GoodsKey.getMiaoshaGoodsStock, "" + goodsId);
        if (stock < 0) {
            response.setMsg(MIAO_SHA_OVER.getMessage());
            response.setStatus(MIAO_SHA_OVER.getCode());
            return response;
        }
        SeckillMessage mm = new SeckillMessage();
        mm.setGoodsId(goodsId);
        mm.setUser(user);
        mqSender.sendMiaoshaMessage(mm);
        return response;
    }

    /**
     * automatically load all seckill goods into redis
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        List<SeckillGoods> goodsList = seckillGoodService.findAll();
        if (goodsList == null) {
            return;
        }
        for (SeckillGoods goods : goodsList) {
            redisService.set(GoodsKey.getMiaoshaGoodsStock, "" + goods.getGoodsId(), goods.getStockCount());
        }
    }
}
