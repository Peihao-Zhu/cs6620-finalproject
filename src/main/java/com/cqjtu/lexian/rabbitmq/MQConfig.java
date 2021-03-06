package com.cqjtu.lexian.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {
    public static final String SECKILL_QUEUE = "seckill.queue";

    @Bean
    public Queue miaosha_queue() {
        return new Queue(SECKILL_QUEUE, true);
    }

}
