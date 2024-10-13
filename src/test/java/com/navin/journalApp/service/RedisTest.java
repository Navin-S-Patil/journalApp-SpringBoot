package com.navin.journalApp.service;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

//    @Disabled
    @Test
    public void testSendMail() {
        redisTemplate.opsForValue().set("email","navinpatilwork@gmail.com");
        Object email = redisTemplate.opsForValue().get("email");
        Object lover = redisTemplate.opsForValue().get("lover");
        int a = 1;

    }
}
